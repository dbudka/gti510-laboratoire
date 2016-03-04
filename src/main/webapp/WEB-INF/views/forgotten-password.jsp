<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div>
    <form id="forgot-form" >
        <p>
            <input id="email" placeholder="Email" name="email" />
            <label for="email">Email required</label>
        </p>

        <label for="user-forgot-send">A email was sent to change your password.</label>
        <p>
            <button type="button" id="user-forgot-send" name="user-form-send" >Change password</button>
        </p>
    </form>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>