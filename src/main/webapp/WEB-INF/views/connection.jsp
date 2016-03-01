<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div>
    <form id="connection-form" >
        <input id="username" name="username" type="text"/>
        <input id="password" name="password" type="password"/>
        <p>Your connection information are incorrect please try again.</p>
        <a>Did you forget your password ? <a href=""> Click here</a>
    </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>