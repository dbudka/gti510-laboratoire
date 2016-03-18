
function Favo(userId, videoId, elementsUI){

    this._userId = userId;
    this._videoId = videoId;
    this._elementsUI = elementsUI;

    var _this = this;

    if(this._elementsUI){
        this._elementsUI.addToFavoriteBtn.click(function () {

            _this.addToFav( _this._videoId);
        });
    }
}

Favo.prototype = {

    addToFav: function ( videoid) {
        if( videoid >= 0) {
            var _this = this;
            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    method: "POST",
                    url: "/api/favorites?vId="+videoid,
                    'dataType': 'json'
                })
                .done(function () {

                })
                .fail(function () {
                    return null;
                });
        }
    },

    deleteFavAt: function (videoId) {
        var _this = this;
        console.log('Deleting...' + videoId);
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "DELETE",
            url: "/api/favorites/" + videoId,
            'dataType': 'json'
        }).done(function( data ) {
            window.location.reload(false);
        }).fail(function(){
            return null;
        })
    }
};