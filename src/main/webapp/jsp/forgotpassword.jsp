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
	<main class="dangky__baoboc">
		<div class="tieude">
			<img src="/BTLWEB_N13/images/icon-white2.png" alt="pomofocus-icon">
			<h1>Pomodoro</h1>
		</div>
		<div class="dangky_chu">
			<h3>Quên mật Khẩu</h3>
		</div>
		<div class="dangky__form">
      		<form action="/BTLWEB_N13/forgot" class="form" method="post">
        		
        		<div style="display: flex; flex-direction: column">
        		<p class="text-danger" style="color: rgb(196, 196, 196);">${msg1}</p>
        		
          			<div style="display: flex; flex-direction: column; margin: 15px 0">
            			<label for="email">Email</label>
            			<input type="email" id="taikhoan" name="email"/>
          			</div>
          			
          			
          		<button class="nut__dangky">Send</button>
        		</div>
      		</form>
    	</div>
		<div class="dangky__cauhoi">
			<span>Bạn đã có tài khoản?</span>
		</div>
		<div class="dangky__link">
			<h3>Đăng nhập</h3>
		</div>
	</main>
</body>
</html>