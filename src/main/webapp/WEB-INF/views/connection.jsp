<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div>
    <form id="connection-form" >
        <p>
            <input id="email" placeholder="Email" name="email" />
            <label for="email">email requiered</label>
        </p>
        <p>
            <input id="password" placeholder="Password" name="password" type="password"/>
            <label for="password">Password requiered</label>
        </p>
        <p>Your connection information are incorrect please try again.</p>
        <p>You are a new ueser ? <a href="/user/create"> Click here</a></p>
        <p>Did you forget your password ? <a href="/user/forgot/password"> Click here</a></p>
    </form>
    <label for="user-connect">The connection information are wrong. Please try again.</label>
    <p>
        <button type="button" id="user-connect" name="user-form-send" >Log in</button>
    </p>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>