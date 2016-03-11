﻿<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="videos" scope="request" type="java.util.List<api.dto.VideoDTO>"></jsp:useBean>
<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div class="container-fluid main">
    <div class="row">
        <nav class="col-xs-3 menu">
            <ul>
                <li class="active"><a href="#">Video section</a></li>
                <li><a href="#">History</a></li>
                <li><a href="/user/connect">Account</a></li>
            </ul>
        </nav>
        <div class="pages col-xs-9">
            <div class="row">
                <div class="col-xs-11">
                    <div class="well page active">
                        <h1 class="header">Video Sections</h1>

                        <form action="/search" method="get">
                            <div class="form-group">
                                <input type="text" class="form-control col-sm-12" placeholder="Search" name="searchVideos">
                                <span class="material-input"></span>
                            </div>
                        </form>

                        <c:forEach items="${videos}" var="video">
                            <div>
                                <h2>${video.name}</h2>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <a href="/${video.id}"><img src="${video.pic}" alt="mcdave" id="${video.url}" /></a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>
</html>