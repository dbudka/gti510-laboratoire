<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" scope="request" type="api.dto.UserDTO"></jsp:useBean>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="header-panel shadow-z-2">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-3">
                    <h1>GTI515 - Video viewer</h1>
                </div>

                <div class="col-xs-3">
                    <c:if test="${not empty user and user.username != null and not empty fn:trim(user.username)}">

                        <div >Welcome ${user.username}  <a href="/user/logout">logout</a></div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>
