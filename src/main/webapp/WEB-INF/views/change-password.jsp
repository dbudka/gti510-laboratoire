<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<jsp:useBean id="id" scope="request"  type="java.lang.String"></jsp:useBean>

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
                    <h1 class="header">Login</h1>

                    <form id="change-password-form" >
                        <input id="id" name="id" type="hidden" value=" ${id} "/>
                        <div class="form-group">
                            <input id="password" placeholder="Password" name="password" type="password" class="form-control"/>
                            <label for="password">Password required</label>
                        </div>
                        <div class="form-group">
                            <input id="password2" placeholder="Password confirmation" name="password2" type="password" class="form-control"/>
                            <label for="password2">Password confirmation needs to be the same as the password)</label>
                        </div>

                        <label for="user-change-password-send">Your password has been reset <a href="/user/connect">click here</a> to connect</label>
                        <input id="user-change-password-send" name="uuser-change-password-send" value="Save new password" class="btn btn-raised btn-default" />
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>