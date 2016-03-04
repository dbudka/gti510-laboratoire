<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="id" scope="request"  type="java.lang.String"></jsp:useBean>

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div>
    <form id="change-password-form" >
        <input id="id" name="id" type="hidden" value=" ${id} "/>
        <p>
            <input id="password" placeholder="Password" name="password" type="password"/>
            <label for="password">Password requiered</label>
        </p>
        <p>
            <input id="password2" placeholder="Password confirmation" name="password2" type="password"/>
            <label for="password2">Password confirmation needs to be the same as the password)</label>
        </p>
        <label for="user-change-password-send">Your password has been reset <a href="/user/connect">click here</a> to connect</label>
        <p>
            <button type="button" id="user-change-password-send" name="user-form-send" >Register</button>
        </p>
 </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>