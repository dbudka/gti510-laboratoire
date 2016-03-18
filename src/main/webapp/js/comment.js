function Comment(userId, videoId, comment, username, id){
    this.id = id;
    this.userId = userId;
    this.videoId = videoId;
    this.username = username;
    this.comment = comment;
    this.postDate = new Date();
    this.serializeData = function(){
        return JSON.stringify(this);
    }
}
function ListComment(userId, videoId, username, limit, page, elementsUI){
    this._comments = [];
    this._userId = userId;
    this._videoId = videoId;
    this._username = username;
    this._elementsUI = elementsUI;
    this._limit = limit;
    this._page = page;
    this._lastPage = false;

    var _this = this;

    this._elementsUI.addCommentButton.click(function () {
        var commentUser = _this._elementsUI.commentUserText.val();
        var comment = new Comment(_this._userId, _this._videoId, commentUser, _this._username);
        _this.addComment(comment);
        _this._elementsUI.commentUserText.val('');
    });

}

ListComment.prototype = {

    addComment: function (commentUser) {
        if(commentUser && commentUser.comment && commentUser.userId != -1) {
            var _this = this;
            console.log(commentUser);
            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    method: "POST",
                    url: "/api/comment",
                    data: commentUser.serializeData(),
                    'dataType': 'json'
                })
                .done(function () {
                    _this.getListCommentFromServerAndShow();
                })
                .fail(function () {
                    alert('error while posting comment');
                    return null;
                });
        }
    },

    deleteCommentAt: function (index) {
        var commentUser = this._comments[index];
        this._comments.splice(index, 1);
        var _this = this;
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "DELETE",
            url: "/api/comment/" + commentUser.id
        }).done(function( data ) {
            return _this.getListCommentFromServerAndShow();
        }).fail(function(){
            return null;
        })
    },

    rebuildList: function () {
        var list = this._elementsUI.list;
        list.empty();
        var _this = this;

        if (_this._comments.length>0) {
            $.each(this._comments, function (i, userComment) {
                var userPostDate = userComment.postDate;

                var comment = $('<li>').attr('class', 'list-group-item').append('<strong>' + userComment.username + '</strong><br>' + " " +
                    userComment.comment + " " + '<p class="text-muted text-right">' + userPostDate.getFullYear() + ' ' + userPostDate.getMonth() + ' ' + userPostDate.getDate() + '</p>');


                if (_this._userId == userComment.userId) {
                    var deleteLink = $('<a>').attr('name', 'deleteComment').attr('id', 'Comment_' + i)
                        .attr('href', 'javascript:void(0);').text('delete comment');

                    deleteLink.click(function (e) {
                        e.preventDefault();
                        var commentIndex = parseInt($(this).attr('id').split('_')[1]);
                        _this.deleteCommentAt(commentIndex);
                    });
                    comment.append(deleteLink);
                }
                list.append(comment);
            });
        } else {
            list.prepend($('<li class="list-group-item" id="no-comment">').append($('<strong>').text('No comment')));
        }

        if(!this._lastPage){
            var getNewLink = $('<a class="btn btn-default btn-raised">').attr('id','getNewComment').attr('href','javascript:void(0);').text('get old comment');

            getNewLink.click(function(e) {
                e.preventDefault();
                _this.getNewPage();
            });

            list.append($('<li class="list-group-item text-center">').append(getNewLink));
        }
    },

    getNewPage: function (){
        this._page += 1;
        this.doAjaxRequestServerForCommentAndRefreshList();
    },

    getListCommentFromServerAndShow: function(){
        this._page = 1;
        this._lastPage = false;
        this._comments.splice(0,this._comments.length);
        this.doAjaxRequestServerForCommentAndRefreshList()
    },

    addCommentsToListFromServer: function(comments){
        var _this = this;
        $.each( comments, function(i, userComment){
            var t = new Comment(userComment.userId, userComment.videoId, userComment.comment,
                userComment.username, userComment.id);
            t.postDate = new Date(userComment.postDate);
            _this._comments.push(t);
        });
        this._lastPage = comments.length == 0 || comments.length != this._limit;
        this.rebuildList();
    },

    doAjaxRequestServerForCommentAndRefreshList: function(){
        var url = "/api/comment/" + this._videoId;
        url = url + "?limit=" + this._limit;
        url = url + "&page=" +  this._page;

        var _this = this;

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET",
            url: url

        }).done(function( data ) {
            _this.addCommentsToListFromServer(data);
        }).fail(function(){
            console.log('fail');
            return null;
        })
    }
};