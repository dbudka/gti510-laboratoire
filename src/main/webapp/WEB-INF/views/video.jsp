<%--
  Created by IntelliJ IDEA.
  User: B
  Date: 2016-03-11
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="video" scope="request" type="api.dto.VideoDTO"></jsp:useBean>
<html>

<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
    <div>
        <h2>${video.name}</h2>
        <div class="embed-responsive embed-responsive-16by9">
            <img src="${video.pic}" alt="mcdave" id="${video.url}" />
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
                        </div>
                    </form>
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
