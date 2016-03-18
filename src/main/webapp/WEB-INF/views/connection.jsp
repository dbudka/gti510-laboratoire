<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<jsp:include page="./partials/head.jsp"/>
<body>
<jsp:include page="./partials/header.jsp"/>
<div>

    <div class="container-fluid main">
        <div class="row">
            <jsp:include page="partials/menu.jsp" />
        </div>
        <div class="pages col-xs-9">
            <div class="row">
                <div class="col-xs-11">
                    <div class="well page active">
                        <h1 class="header">Login</h1>

                        <form id="connection-form" >
                            <div class="form-group">
                                <input id="email" placeholder="Email" name="email" class="form-control" />
                                <label for="email">email requiered</label>
                            </div>
                            <div class="form-group">
                                <input id="password" placeholder="Password" name="password" type="password" class="form-control"/>
                                <label for="password">Password requiered</label>
                            </div>
                            <div class="col-xs-12">
                                <p>Your connection information are incorrect please try again.</p>
                                <p>You are a new user ? <a href="/user/create"> Click here</a></p>
                                <p>Did you forget your password ? <a href="/user/forgot/password"> Click here</a></p>
                            </div>
                            <label for="user-connect">The connection information are wrong. Please try again.</label>
                            <input  id="user-connect" name="user-connect" value="Log in" class="btn btn-raised btn-default" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./partials/footer.jsp"/>
</body>

</html>