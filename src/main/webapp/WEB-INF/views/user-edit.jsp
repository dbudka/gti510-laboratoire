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
                    <h1 class="header">Sign in</h1>

                    <form id="connection-form" method="get">
                        <div class="form-group">
                            <input id="username" placeholder="Display name" name="username" type="text" class="form-control"/>
                            <label for="username">username requiered</label>
                        </div>
                        <div class="form-group">
                            <input id="email" placeholder="Email" name="email" class="form-control" />
                            <label for="email">email requiered</label>
                        </div>
                        <div class="form-group">
                            <input id="password" placeholder="Password" name="password" type="password" class="form-control" />
                            <label for="password">Password requiered</label>
                        </div>
                        <div class="form-group">
                            <input id="password2" placeholder="Password confirmation" name="password2" type="password" class="form-control" />
                            <label for="password2">Password confirmation needs to be the same as the password)</label>
                        </div>
                        <div class="col-xs-12">
                            <p>Your connection information are incorrect please try again.</p>
                            <p>You are a new ueser ? <a href="/user/create"> Click here</a></p>
                            <p>Did you forget your password ? <a href="/user/forgot/password"> Click here</a></p>
                        </div>
                    </form>
                    <label for="user-form-send">The email is already being used by another user.</label>
                    <input type="submit" id="user-form-send" name="user-form-send" class="btn btn-raised btn-default" value="Register" />
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>