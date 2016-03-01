<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="video" scope="request"  type="api.dto.VideoDTO"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div>
    <form id="connection-form" >
        <p>Please let us know who your are and we will send you a request to change your password.</p>
        <input id="email" placeholder="Email" name="email" type="text"/>
    </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>