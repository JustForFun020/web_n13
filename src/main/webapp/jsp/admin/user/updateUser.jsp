<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form html</title>

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-12">

            </div>
            <div class="col-md-9 col-sm-12">
                <form action="/BTLWEB_N13/admin/user/update" method="post">
                    <div class="form-group">
                        <label>ID:</label>
                        <input name="userID" value="${user.userID}" class="form-control" type="text" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>Tên:</label>
                        <input value="${user.fullName}" class="form-control" type="text" name="fullName" placeholder="Nhập tên">
                    </div>
                    <div class="form-group">
                        <label>Username:</label>
                        <input value="${user.username}" class="form-control" type="text" name="username" placeholder="Nhập tài khoản">
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input value="${user.password}" class="form-control" type="password" name="password" placeholder="Nhập mật khẩu">
                    </div>
                    <div class="form-group">
                        <label>Role:</label>
                        <select name="role" class="form-control">
                            <c:if test="${user.role=='admin'}">
                                <option value="ROLE_MEMBER">member</option>
                                <option value="ROLE_ADMIN" selected>admin</option>
                            </c:if>
                            <c:if test="${user.role=='member'}">
                                <option value="ROLE_MEMBER" selected>member</option>
                                <option value="ROLE_ADMIN">admin</option>
                            </c:if>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Ảnh URL:</label>
                        <input value="${user.image}" name="image" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Cập nhật">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>