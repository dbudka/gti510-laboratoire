<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div>
    <form id="connection-form"  >
        <fieldset>
            <p>
                <input id="username" placeholder="Display name" name="username" type="text"/>
                <label for="username">username requiered</label>
            </p>
            <p>
                <input id="email" placeholder="Email" name="email" />
                <label for="email">email requiered</label>
            </p>
            <p>
                <input id="password" placeholder="Password" name="password" type="password"/>
                <label for="password">Password requiered</label>
            </p>
            <p>
                <input id="password2" placeholder="Password confirmation" name="password2" type="password"/>
                <label for="password2">Password confirmation needs to be the same as the password)</label>
            </p>
        </fieldset>
    </form>
    <label for="user-form-send">The email is already being used by another user.</label>
    <p>
        <button type="button" id="user-form-send" name="user-form-send" >Register</button>
    </p>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>