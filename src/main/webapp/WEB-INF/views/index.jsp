﻿﻿<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

                        <div>
                            <h2>${video.name}</h2>
                            <div class="embed-responsive embed-responsive-16by9">
                                <iframe class="embed-responsive-item" src="${video.url}" frameborder="0" allowfullscreen></iframe>
                            </div>
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
                                                <input type="hidden" id="userId" value="2">
                                                <input type="hidden" id="videoId" value="${video.id}">
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
    refreshComment(${video.id}, 1, 5, true);
</script>
</body>

</html>