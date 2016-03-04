function allUserEvents() {

    createEditUser();
    resetPassword();
    connectUser();
    changeUserPassword();
}

function createEditUser() {

    $('label  ').css('display', 'none');
    $('#user-form-send').click(function () {


        $('label  ').css('display', 'none');
        var form = $('#connection-form');

        var val_user = !validator.isNull($("#username").val());
        var val_pass = !validator.isNull($("#password").val());
        var val_conf_pass = validator.equals($("#password").val(), $("#password2").val());
        var val_email = validator.isEmail($("#email").val());

        if(!val_user) {
            $('label[for="username"]').css('display', 'inline-block');
        }

        if(!val_pass) {
            $('label[for="password"]').css('display', 'inline-block');
        }

        if(!val_conf_pass) {
            $('label[for="password2"]').css('display', 'inline-block');
        }

        if(!val_email) {
            $('label[for="email"]').css('display', 'inline-block');
        }

        if (val_user && val_pass && val_conf_pass && val_email) {

                $.ajax({
                    url: '/api/users/',
                    type: 'POST',
                    dataType: 'json',
                    data: form.serialize(),
                    beforeSend: function () {

                    },
                    success: function (data) {
                        window.location.href = "/user/edit";
                    },
                    error: function (xhr, status, error) {

                        $('label[for="user-form-send"]').css('display', 'inline-block');
                    }
                });
        }
    })
}

function connectUser() {

    $('label  ').css('display', 'none');
    $('#user-connect').click(function () {

        $('label  ').css('display', 'none');
        var form = $('#connection-form');

        var val_email= validator.isEmail($("#email").val());
        var val_pass = !validator.isNull($("#password").val());

        if(!val_email) {
            $('label[for="email"]').css('display', 'inline-block');
        }

        if(!val_pass) {
            $('label[for="password"]').css('display', 'inline-block');
        }

        if ( val_pass && val_email) {


            $.ajax({
                url: '/api/users/connect',
                type: 'POST',
                dataType: 'json',
                data: form.serialize(),
                beforeSend: function () {
                },
                success: function (data) {
                    alert("sd");
                    window.location.href = "/user/edit";
                },
                error: function (xhr, status, error) {

                    $('label[for="user-form-send"]').css('display', 'inline-block');
                }
            });
        }
    })
}

function resetPassword() {

    $('label  ').css('display', 'none');
    $('#user-forgot-send').click(function () {

        $('label  ').css('display', 'none');
        var form = $('#forgot-form');

        var val_email= validator.isEmail($("#email").val());

        if(!val_email) {
            $('label[for="email"]').css('display', 'inline-block');
        }

        if ( val_email) {

            $.ajax({
                url: '/api/users/password/request',
                type: 'POST',
                dataType: 'json',
                data: form.serialize(),
                beforeSend: function () {
                },
                success: function (data) {
                    alert("sd");
                    $('label[for="user-forgot-send"]').css('display', 'inline-block');

                },
                error: function (xhr, status, error) {
                    alert("une err merde !");
                }
            });
        }
    })
}

function changeUserPassword() {

    $('label  ').css('display', 'none');
    $('#user-change-password-send').click(function () {

        $('label  ').css('display', 'none');
        var form = $('#change-password-form');

        var val_pass = !validator.isNull($("#password").val());
        var val_conf_pass = validator.equals($("#password").val(), $("#password2").val());

        if(!val_pass) {
            $('label[for="password"]').css('display', 'inline-block');
        }

        if(!val_conf_pass) {
            $('label[for="password2"]').css('display', 'inline-block');
        }

        if (val_pass && val_conf_pass) {

            $.ajax({
                url: '/api/users/password/confirm',
                type: 'POST',
                dataType: 'json',
                data: form.serialize(),
                beforeSend: function () {

                },
                success: function (data) {
                    $('label[for="user-change-password-send"]').css('display', 'inline-block');
                },
                error: function (xhr, status, error) {
                    alert("c' est la faute a marco !" + xhr.responseText);
                }
            });
        }
    })
}

