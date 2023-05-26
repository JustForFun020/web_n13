<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo người dùng mới</title>
    <!-- Thêm các tệp CSS và JavaScript cần thiết -->
    <link rel="stylesheet" href="/path/to/bootstrap.css">
    <script src="/path/to/jquery.js"></script>
    <script src="/path/to/bootstrap.js"></script>
</head>
<body>
    <div class="container">
        <h1>Tạo người dùng mới</h1>
        <form action="/BTLWEB_N13/admin/user/add" method="post">
        <div class="form-group">
                <label for="fullname">ID:</label>
                <input type="text" class="form-control" id="userID" name="userID" required>
            </div>
            <div class="form-group">
                <label for="fullname">Họ và tên:</label>
                <input type="text" class="form-control" id="fullName" name="fullName" required>
            </div>
            <div class="form-group">
                <label for="username">Email:</label>
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
                    <option value="member">Member</option>
                    <option value="admin">Admin</option>
                </select>
            </div>
            <div class="form-group">
                <label for="fullname">LinkURL:</label>
                <input type="text" class="form-control" id="image" name="image" required>
            </div>
            <button type="submit" class="btn btn-primary">Tạo người dùng</button>
        </form>
    </div>
</body>
</html>
