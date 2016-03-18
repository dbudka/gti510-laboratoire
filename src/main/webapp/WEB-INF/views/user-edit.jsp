<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" scope="request" type="api.dto.UserDTO"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>

<div class="container-fluid main">
    <div class="row">
        <jsp:include page="partials/menu.jsp" />
    </div>
    <div class="pages col-xs-9">
        <div class="row">
            <div class="col-xs-11">
                <div class="well page active">

                    <c:choose>
                        <c:when test="${not empty user and user.username != null and not empty fn:trim(user.username)}">
                            <h1 class="header">Edit</h1>
                        </c:when>
                        <c:otherwise>
                            <h1 class="header">Register</h1>
                        </c:otherwise>
                    </c:choose>

                    <form id="connection-form" >
                        <div class="form-group">
                            Username:
                            <input id="username" placeholder="Display name" name="username" type="text" class="form-control" value="<c:if test="${not empty user and user.username != null and not empty fn:trim(user.username)}">${user.username}</c:if>"/>
                            <label for="username">username required</label>
                        </div>
                        <div class="form-group">
                            <c:choose>
                                <c:when test="${not empty user and user.username != null and not empty fn:trim(user.username)}">
                                    Email:
                                    <input id="email" disabled placeholder="Email" name="email" class="form-control" value="${user.email}" />
                                </c:when>
                                <c:otherwise>
                                    <input id="email" placeholder="Email" name="email" class="form-control" value="" />
                                    <label for="email">email requiered</label>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="form-group">
                            <input id="password" placeholder="Password" name="password" type="password" class="form-control" />
                            <label for="password">Password requiered</label>
                        </div>
                        <div class="form-group">
                            <input id="password2" placeholder="Password confirmation" name="password2" type="password" class="form-control" />
                            <label for="password2">Password confirmation needs to be the same as the password)</label>
                        </div>

                        <c:choose>
                            <c:when test="${not empty user and user.username != null and not empty fn:trim(user.username)}">
                                <input id="id" name="id" type="hidden" value="${user.id}">
                            </c:when>
                            <c:otherwise>
                                <div class="col-xs-12">
                                    <p>Your connection information are incorrect please try again.</p>
                                    <p>You are a new user ? <a href="/user/create"> Click here</a></p>
                                    <p>Did you forget your password ? <a href="/user/forgot/password"> Click here</a></p>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </form>

                    <c:choose>
                        <c:when test="${not empty user and user.username != null and not empty fn:trim(user.username)}">

                        </c:when>
                        <c:otherwise>
                            <label for="user-form-send">The email is already being used by another user.</label>
                        </c:otherwise>
                    </c:choose>
                    <input  id="user-form-send" name="user-form-send" class="btn btn-raised btn-default" value="Register" />
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>