<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="video" scope="request" type="api.dto.VideoDTO"></jsp:useBean>
<html>

<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div class="container-fluid main">
    <div class="row">
        <jsp:include page="partials/menu.jsp" />
        <div class="pages col-sm-12 col-md-9">
            <div class="row">
                <div class="col-xs-11">
                    <div class="well page active">
                        <h2 class="header">${video.name}</h2>
                        <div>
                            <img class="youtube" src="${video.pic}" alt="mcdave" id="${video.url}" data-toggle="modal" data-target="#myModal"/>
                        </div>
                        <hr>
                        <div class="panel panel-default">
                            <div class="panel-heading">Comment section</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="comment-loading" style="display: none;">
                                            <img class="loading" src="/images/ring-alt.gif" alt="ajax_loader">
                                        </div>
                                        <ul id="commentList" class="list-group"></ul>
                                    </div>
                                </div>
                                <c:if test="${ !(empty user.id) }">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <form action="#" method="post">
                                                <div class="col-xs-12">
                                                    <label for="commentUser" class="control-label">Comment</label>
                                                    <textarea id="commentUser" class="form-control" rows="5"></textarea>
                                                </div>
                                                <div class="col-xs-12">
                                                    <input type="button" id="addComment" class="btn btn-raised btn-default" value="Post comment">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="embed-responsive embed-responsive-16by9">
                <div id="ytPlayer"></div>
                <!--<iframe class="embed-responsive-item" src="..."></iframe>-->
            </div>
        </div>
    </div>
</div>
    <jsp:include page="./partials/footer.jsp"/>
    <script type="text/javascript" src="<c:url value="/js/comment.js" />" ></script>
    <script type="text/javascript" src="https://www.youtube.com/player_api" ></script>
    <script type="text/javascript">
        var username = '${user.username}';
        var userId = -1;
        <c:choose>
            <c:when  test="${ !(empty user.id) }">
                userId = ${user.id};
                function onYouTubePlayerAPIReady() {
                    jQuery(document).ready(function($){
                        $('.youtube').mousedown(function(){
                            // Replace the 'ytplayer' element with an <iframe> and
                            // YouTube player after the API code downloads.
                            var player;
                            player = new YT.Player('ytPlayer', {
                                videoId: '${video.url}',
                                playerVars: {'autoplay': 1, 'rel': 0},
                                events: {
                                    'onStateChange': onPlayerStateChange
                                }
                            });
                            $('#ytPlayer').addClass('embed-responsive-item');
                            // when video ends
                            function onPlayerStateChange(event) {
                                if(event.data === 0) {
                                    $('#myModal').modal('hide');
                                }
                            }
                        });
                        $(".modal-backdrop, #myModal .close, #myModal .btn").on("click", function() {
                            $("#myModal iframe").attr("src", $("#myModal iframe").attr("src"));
                        });
                    });
                }
            </c:when>
            <c:otherwise>
                function onYouTubePlayerAPIReady() {
                    jQuery(document).ready(function($){
                        $('.youtube').mousedown(function(){
                            // Replace the 'ytplayer' element with an <iframe> and
                            // YouTube player after the API code downloads.
                            var player;
                            player = new YT.Player('ytPlayer', {
                                videoId: '${video.url}',
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
                        $(".modal-backdrop, #myModal .close, #myModal .btn").on("click", function() {
                            $("#myModal iframe").attr("src", $("#myModal iframe").attr("src"));
                        });
                    });
                }
            </c:otherwise>
        </c:choose>
        var listComment = new ListComment(userId, ${video.id}, username, 5, 1, {
            'list': $('#commentList'),
            'addCommentButton': $('#addComment'),
            'commentUserText': $('#commentUser')
        });

        listComment.getListCommentFromServerAndShow();


        $(document).ajaxStart(function(){
            $('#comment-loading').css('display','block');
        });
        $(document).ajaxComplete(function(){
            $('#comment-loading').css('display','none');
        });
    </script>
</body>
</html>
