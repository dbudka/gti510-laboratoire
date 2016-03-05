<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>

<div class="container-fluid main">
    <div class="row">
        <nav class="col-xs-3 menu">
            <ul>
                <li><a href="/">Video section</a></li>
                <li><a href="#">History</a></li>
                <li class="active"><a href="/user/connect">Account</a></li>
            </ul>
        </nav>
    </div>
    <div class="pages col-xs-9">
        <div class="row">
            <div class="col-xs-11">
                <div class="well page active">
                    <h1 class="header">Forgot Password</h1>

                    <form id="forgot-form" method="get" action="#">
                        <div class="form-group">
                            <input id="email" placeholder="Email" name="email" class="form-control" />
                            <label for="email">Email required</label>
                        </div>

                        <label for="user-forgot-send">A email was sent to change your password.</label>
                        <input type="submit" id="user-forgot-send" name="user-form-send" value="Change Password" class="btn btn-raised btn-default" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="./partials/footer.jsp"/>
</body>

</html>