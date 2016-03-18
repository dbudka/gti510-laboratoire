<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" scope="request" type="api.dto.UserDTO"></jsp:useBean>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="col-xs-12 col-md-3 menu">
    <ul>
        <li><a href="/">Video section</a></li>
        <li><a href="#">History</a></li>
        <li><a href="/user/edit">Account</a></li>
        <c:if test="${not empty user and user.username != null and not empty fn:trim(user.username)}">
            <li><a href="/user/logout">Logout</a></li>
        </c:if>
    </ul>
</nav>