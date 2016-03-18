<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="videofavorites" scope="request" type="java.util.List<api.dto.FavoritesDTO>"></jsp:useBean>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="row">
                            <c:forEach items="${videofavorites}" var="favorites">
                                <div class="col-xs-12 col-sm-6">
                                    <a href="/${favorites.video.id}"><h3 class="upper-padding-10">${favorites.video.name}</h3></a>
                                    <input type="button" class="btn btn-raised btn-default" value="Delete video from favorites" onclick="setVideoId(${favorites.video.id})">
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <a href="/${favorites.video.id}"><img src="${favorites.video.pic}" alt="mcdave" id="${favorites.video.url}" class="img-responsive" /></a>
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
<jsp:include page="./partials/footer.jsp"/>
<script type="text/javascript" src="<c:url value="/js/favorites.js" />" ></script>
<script type="text/javascript">
    var username = '${user.username}';
    var userId = -1;
    <c:if test="${ !(empty user.id) }">
    userId = ${user.id};
    </c:if>
    var favo = new Favo(userId, null, null);
    function setVideoId(id){
       favo.deleteFavAt(id);
        console.log('deleting... '+ id);
    }


</script>
</body>
</html>