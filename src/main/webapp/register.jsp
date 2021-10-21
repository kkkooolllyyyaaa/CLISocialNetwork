<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
    <link rel="stylesheet" href="css/auth.css">
</head>
<body style='background-image: url("imgs/wallpaperbetter.jpg");'>

<div class="container-fluid">
    <div class="row">
        <div class="col-7">

        </div>
        <div class="col-4 auth-side">

            <form id="form" action="reg" method="post">
                <div class="mb-3">
                    <label for="login-form" class="form-label">Your login</label>
                    <input type="text" class="form-control" id="login-form" placeholder="@login_example" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Your password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="mb-3">
                    <label for="password-confirm" class="form-label">Confirm password</label>
                    <input type="password" class="form-control" id="password-confirm" name="password-confirm">
                </div>
                <button type="submit" class="btn btn-secondary" id="reg">Register</button>
                <a href="login.jsp">Sign in</a>
            </form>

        </div>
    </div>
</div>
<script src="js/auth.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
</body>
</html>