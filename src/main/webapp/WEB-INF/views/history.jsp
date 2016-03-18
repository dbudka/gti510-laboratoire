<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="videohistory" scope="request" type="java.util.List<api.dto.HistoryDTO>"></jsp:useBean>

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
                            <c:forEach items="${videohistory}" var="history">
                                <div class="col-xs-12 col-sm-6">
                                    <a href="/${history.video.id}"><h3 class="upper-padding-10">${history.video.name}</h3></a>
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <a href="/${history.video.id}"><img src="${history.video.pic}" alt="mcdave" id="${history.video.url}" class="img-responsive" /></a>
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
</body>

</html>