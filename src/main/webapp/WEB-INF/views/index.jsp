<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>
<jsp:useBean id="comments" scope="request" type="java.util.List<api.dto.CommentDTO>"></jsp:useBean>

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
                        <h1 class="header">Video Section</h1>

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
                        <div>
                            Comment section
                            <c:if test="${!empty comments}">
                                <ul>
                                    <c:forEach var="comment" items="${comments}">
                                        <li>
                                            <c:out value="${comment.username}"/>
                                            <c:out value="${comment.postDate}"/>
                                            <c:out value="${comment.comment}"/>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
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