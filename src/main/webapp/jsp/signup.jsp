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
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="stylesheet" href="../css/signup.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
</head>
<body>
	<main class="dangky__baoboc">
		<div class="tieude">
			<img src="../images/icon-white2.png" alt="pomofocus-icon">
			<h1>Pomodoro</h1>
		</div>
		<div class="dangky_chu">
			<h3>Đăng Ký</h3>
		</div>
		<div class="dangky__form">
      		<form action="" class="form">
        		<div class="form__chu">
          			<h1 style="color: rgb(196, 196, 196)">Đăng ký</h1>
        		</div>
        		<div style="display: flex; flex-direction: column">
        		<div style="display: flex; flex-direction: column; margin: 15px 0">
            			<label for="fullname">Họ và Tên</label>
            			<input type="text" id="fullname" />
          			</div>
          			<div style="display: flex; flex-direction: column; margin: 15px 0">
            			<label for="taikhoan">Tài Khoản</label>
            			<input type="text" id="taikhoan" />
          			</div>
          			<div style="display: flex; flex-direction: column; margin-bottom: 20px">
            			<label for="matkhau">Mật Khẩu</label>
            			<input type="text" id="matkhau" />
          			</div>
          			<div style="display: flex; flex-direction: column; margin-bottom: 20px">
            			<label for="xacnhanmatkhau">Xác Nhận Mật Khẩu</label>
            			<input type="text" id="xacnhanmatkhau" />
          			</div>
          		<button class="nut__dangky">Đăng Ký</button>
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