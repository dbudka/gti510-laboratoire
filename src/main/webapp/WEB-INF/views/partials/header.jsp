<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" scope="request" type="api.dto.UserDTO"></jsp:useBean>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="header-panel shadow-z-2">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-6 col-md-3">
                    <a href="/"><h1>GTI515 - Video viewer</h1></a>
                </div>

                <div class="col-xs-6 col-md-3" style="z-index: 5; color: white;">
                    <c:if test="${not empty user and user.username != null and not empty fn:trim(user.username)}">
                        <div>
                            <span>Welcome ${user.username}</span>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>
