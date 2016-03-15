function onYouTubePlayerAPIReady() {
    jQuery(document).ready(function($){
        $('.youtube').mousedown(function(){
            // Replace the 'ytplayer' element with an <iframe> and
            // YouTube player after the API code downloads.
            var player;
            player = new YT.Player('ytPlayer', {
                videoId: 'M7lc1UVf-VE',
                playerVars: {'autoplay': 1, 'controls': 0, 'start': 5, 'end': 20, 'rel': 0},
                events: {
                    'onStateChange': onPlayerStateChange
                }
            });
            $('#ytPlayer').addClass('embed-responsive-item');
            // when video ends
            function onPlayerStateChange(event) {
                if(event.data === 0) {
                    $('#myModal').modal('hide');
                    alert('To see more, login!');
                }
            }
        });
        $(".modal-backdrop, #myModal .close, #myModal .btn").live("click", function() {
            $("#myModal iframe").attr("src", $("#myModal iframe").attr("src"));
        });
    });
}
