﻿<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>

<div class="container-fluid main">
    <div class="row">
        <nav class="col-xs-3 menu">
            <ul>
                <li class="active"><a href="#">Video section</a></li>
                <li><a href="#">History</a></li>
                <li><a href="#">Account</a></li>
            </ul>
        </nav>
        <div class="pages col-xs-9">
            <div class="row">
                <div class="col-xs-11">
                    <div class="well page active">
                        <h1 class="header">Video Sections</h1>

                        <form>
                            <div class="form-group">
                                <input type="text" class="form-control col-sm-12" placeholder="Search">
                                <span class="material-input"></span>
                            </div>
                        </form>

                        <p>Hello world! Jeyyy !!! transforme moi en quelquechose de beau PLS !</p>
                        <div>
                            This is the video for a test to DB :
                            <p>${video.id}</p>
                            <p>${video.name}</p>
                            <a href="${video.url}">${video.url}</a>
                        </div>
                        <hr>
                        <div class="panel panel-default">
                            <div class="panel-heading">Comment section</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <ul id="commentList">
                                        </ul>
                                    </div>
                                </div>
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="./partials/footer.jsp"/>
<script type="text/javascript" src="<c:url value="/js/comment.js" />" ></script>
<script type="text/javascript">
    var username = '${user.username}';
    var userId = -1;
    <c:if test="${ !(empty user.id) }">
    userId = ${user.id};
    </c:if>
    var listComment = new ListComment(userId, ${video.id}, username, 5, 1, {
                'list': $('#commentList'),
                'addCommentButton': $('#addComment'),
                'commentUserText': $('#commentUser')
            });

            listComment.getListCommentFromServerAndShow();
</script>
</body>

</html>