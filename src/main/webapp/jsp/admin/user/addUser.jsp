<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo người dùng mới</title>
    <!-- Thêm các tệp CSS và JavaScript cần thiết -->
    <link rel="stylesheet" href="/path/to/bootstrap.css">
    <link rel="stylesheet" href="/BTLWEB_N13/css/admin/AddUser.css" />
	<link rel="stylesheet" href="/BTLWEB_N13/css/styles.css" />
    <script src="/path/to/jquery.js"></script>
    <script src="/path/to/bootstrap.js"></script>
</head>
<body>
    <div class="container">
    	<div class="baoboc__form__taonguoidung ">
        	<div class="form__tieude">Tạo người dùng mới</div>
        	<div class="khoangcach"></div>
        	<form action="/BTLWEB_N13/admin/user/add" method="post" class="form__taonguoidung">
        		<div class="form-group">
                	<label for="userID">ID:</label>
                	<input type="text" class="form-control" id="userID" name="userID" required>
            	</div>
            	<div class="form-group">
                	<label for="fullName">Họ và tên:</label>
                	<input type="text" class="form-control" id="fullName" name="fullName" required>
            	</div>
            	<div class="form-group">
                	<label for="email">Email:</label>
                	<input type="text" class="form-control" id="email" name="email" required>
            	</div>
            	<div class="form-group">
                	<label for="username">Tên người dùng:</label>
                	<input type="text" class="form-control" id="username" name="username" required>
            	</div>
            	<div class="form-group">
                	<label for="password">Mật khẩu:</label>
                	<input type="password" class="form-control" id="password" name="password" required>
            	</div>
            	<div class="form-group">
                	<label for="role">Vai trò:</label>
                	<select class="form-control" id="role" name="role" required>
                    	<option value="user">User</option>
                    	<option value="admin">Admin</option>
                	</select>
            	</div>
            	<div class="form-group">
                	<label for="image">LinkURL:</label>
                	<input type="text" class="form-control" id="image" name="image">
            	</div>
            	<button type="submit">Tạo người dùng</button>
        	</form>
    	</div>
    </div>
</body>
</html>