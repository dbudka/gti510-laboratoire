﻿﻿<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="videos" scope="request" type="java.util.List<api.dto.VideoDTO>"></jsp:useBean>
<html lang="en">
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
                        <h2 class="header">Video Section</h2>

                        <form action="/search" method="get">
                            <div class="form-group">
                                <input type="text" class="form-control col-sm-12" placeholder="Search" name="searchVideos">
                                <span class="material-input"></span>
                            </div>
                        </form>

                        <div class="row">
                            <div class="col-sx-12">
                                <c:forEach items="${videos}" var="video">
                                    <div class="col-xs-12 col-sm-6">
                                        <a href="/${video.id}"><h3 class="upper-padding-10">${video.name}</h3></a>
                                        <div class="embed-responsive embed-responsive-16by9">
                                            <a href="/${video.id}"><img src="${video.pic}" alt="mcdave" id="${video.url}" class="img-responsive" /></a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>