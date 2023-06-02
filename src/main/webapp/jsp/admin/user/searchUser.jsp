<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List User</title>
	<link rel="stylesheet" href="/BTLWEB_N13/css/admin/SearchUser.css" />
	<link rel="stylesheet" href="/BTLWEB_N13/css/styles.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="phandau__danhsach_nguoidung">
				<div class="nut-them__nguoidung">
					<a href="/BTLWEB_N13/admin/user/add" class="btn btn-primary">Thêm mới</a>
				</div>
				<div class="danhsach__nguoidung__tieude">Danh Sách Người Dùng</div>
				<form class="form-inline form__timkiem__nguoidung" action="/BTLWEB_N13/admin/user/search"
					method="post">
					<input class="form-control" name="keyword" type="text"
						placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tìm</button>
				</form>
			</div>
			<table class="table table-hover danhsach__nguoidung">
				<tr class="table-header">
					<th>ID</th>
					<th>Full Name</th>
					<th>Email</th>
					<th>Username</th>
					<th>Password</th>
					<th>Role</th>
					<th>Image</th>
					<th>Last Login</th>
					<th>Lựa chọn</th>
				</tr>
				<tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.userID}</td>
							<td>${user.fullName}</td>
							<td>${user.email}</td>
							<td>${user.username}</td>
							<td>${user.password}</td>
							<td>${user.role}</td>
							<td class="anhdaidien__nguoidnung"><img class="card-img-top" src="${user.image}" alt="anhnguoidung" /></td>
							<td>${user.lastLogin}</td>
							<td class="danhsach__form">
								<form action="/BTLWEB_N13/admin/user/update" method="post" style="margin-bottom: 4px">
									<input type="hidden" name="uid" value="${user.getUserID()}">
									<button type="submit" class="btn btn-danger">Sửa</button>
								</form>
								<form action="/BTLWEB_N13/admin/user/delete" method="get">
									<input type="hidden" name="userID" value="${user.getUserID()}">
									<button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>