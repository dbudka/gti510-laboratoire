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

function PostComment(comment, videoId, userId){
    if(comment) {
        var newComment = new Comment(userId, videoId, comment, null, null);
        var page = 1;
        var limit = 5;
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            url: "/api/comment",
            data: newComment.serializeData(),
            'dataType': 'json'
        })
            .done(function () {
                return refreshComment(videoId, page, limit, true);
            })
            .fail(function () {
                alert('error while posting comment');
                return null;
            });
    }
}
function getCommentAndRefreshList(page, limit, videoId, clearList){
    var url = "/api/comment/" + videoId;

    if(limit){
        url = url + "?limit=" + limit;
        if(page){
            url = url + "&page=" + page;
        }
    }
    else if(page){
        url = url + "?page=" + page;
    }
    console.log(url);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "GET",
        url: url

    }).done(function( data ) {
        console.log('succes');
        console.log(data);
        //console.log(JSON.parse(data));
        return refreshList(data, videoId, page, limit, clearList);
    }).fail(function(){
        console.log('fail');
        return null;
    })
}

function deleteComment(commentId, videoId){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "DELETE",
        url: "/api/comment/" + commentId
    }).done(function( data ) {
        return refreshComment(videoId,null,null, true);
    }).fail(function(){
        return null;
    })
}

function refreshComment(videoId, page, limit, clearList){
    if(!limit){
        limit = 5;
    }
    if(!page){
        page = 1;
    }
    getCommentAndRefreshList(page, limit, videoId, clearList);
}

function refreshList(comments, videoId, page, limit, clearList){
    console.log('page ' + page);
    var addGetComment = comments.length == limit;
    if(clearList) {
        $('#commentList').empty();
    }
    else{
        $('#commentList li:last').remove();
    }
    $.each( comments, function(i, userComment){
        $('#commentList').append(
            $('<li>')
                .append(userComment.username + " " + userComment.comment + " " + (new Date(userComment.postDate)).toString() + " ")
                .append($('<a>').attr('name','deleteComment').attr('id','Comment_' + userComment.id + "_" + userComment.videoId)
                    .attr('href','javascript:void(0);').text('delete comment'))
        );
    });
    if(addGetComment){
        var pageDisplay = page + 1;
        $('#commentList').append(
            $('<li>')
                .append($('<a>').attr('id','getNewComment').attr('name','getNewComment_' + videoId + "_" + pageDisplay + "_" + limit)
                    .attr('href','javascript:void(0);').text('get old comment'))
        );
        $('#getNewComment').click(function(e) {
            e.preventDefault();
            var videoId = parseInt($(this).attr('name').split('_')[1]);
            var page = parseInt($(this).attr('name').split('_')[2]);
            var limit = parseInt($(this).attr('name').split('_')[3]);
            refreshComment(videoId, page, limit, false);
        });
    }
    $('a[name=deleteComment]').click(function(e) {
        e.preventDefault();
        var commentid =  parseInt($(this).attr('id').split('_')[1]);
        var videoId = parseInt($(this).attr('id').split('_')[2]);
        deleteComment(commentid,videoId);
    });
}

$( document ).ready(function($) {
    $.material.init();
    $("input#addComment").click(function() {
        var userId = parseInt($('#userId').val());
        var videoId = parseInt($('#videoId').val());
        var commentUser = $('textarea#commentUser').val();
        PostComment(commentUser, videoId, userId);
        $('textarea#commentUser').val('');
    });
});
