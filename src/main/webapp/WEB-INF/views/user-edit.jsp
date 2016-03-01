<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<div>
    <form id="connection-form" action="">
        <input id="user" placeholder="Display name" name="user" type="text"/>
        <input id="email" placeholder="Email" name="email" type="text"/>
        <input id="password" placeholder="Password" name="password" type="password"/>
        <input id="password2" placeholder="Password confirmation" name="password2" type="password"/>
        <button type="submit" value="Register" id="user-form-send">Register</button>
        <p id="form-error"></p>
    </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>