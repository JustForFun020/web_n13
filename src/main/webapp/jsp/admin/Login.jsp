<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >


    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pomodoro Timer Online - Pomofocus</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" href="/BTLWEB_N13/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/BTLWEB_N13/css/styles.css" />
    <link rel="stylesheet" href="/BTLWEB_N13/css/login.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
</head>
<body>
	<main class="dangnhap__baoboc">

		<div class="tieude">
			<img src="/BTLWEB_N13/images/icon-white2.png" alt="pomofocus-icon">
			<h1>Pomodoro</h1>
		</div>
		<div class="dangnhap_chu">
			<h3>Đăng nhập</h3>
		</div>

		<div class="dangnhap__form">

			<form class="form" role="form" action="/BTLWEB_N13/login-admin" method="post">

        		<div class="form__chu">
          			<h1 style="color: rgb(196, 196, 196)">Đăng Nhập</h1>
        		</div>

        		<div style="display: flex; flex-direction: column">

          			<div style="display: flex; flex-direction: column; margin: 15px 0">
          			<p class="text-danger" style="color: rgb(196, 196, 196);">${msg1}</p>
            			<label for="taikhoan">Tài Khoản</label>
            			<input type="text" id="taikhoan" name="username"/>
          			</div>
          			<div style="display: flex; flex-direction: column; margin-bottom: 20px">
            			<label for="matkhau">Mật Khẩu</label>
            			<input type="password" id="matkhau" name="password"  />
          			</div>
          		<button class="nut__dangnhap">Đăng Nhập</button>

        		</div>
      		</form>
    	</div>

	</main>
</body>
</html>