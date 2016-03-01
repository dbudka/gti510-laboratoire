<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div>
    <form id="connection-form" >
        <input id="password" placeholder="Password" name="password" type="password"/>
        <input id="password-confirmation" placeholder="Confirm passowrd" name="password-confirmation" type="password"/>
    </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>