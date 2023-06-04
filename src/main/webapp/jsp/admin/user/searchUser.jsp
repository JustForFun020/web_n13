<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12"></div>
			<div class="col-md-9 col-sm-12">
				<a href="/BTLWEB_N13/admin/user/add" class="btn btn-primary">Thêm
					mới</a>
				<form class="form-inline" action="/BTLWEB_N13/admin/user/search"
					method="post">
					<input class="form-control" name="keyword" type="text"
						placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tìm</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Username</th>
						<th>Password</th>
						<th>Role</th>
						<th>Image</th>
					
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
								<td><img class="card-img-top" src="${user.image}"
									alt="anhnguoidung" style="width: 90px; height: 90px;"></td>
								

								<td>
									<form action="/BTLWEB_N13/admin/user/update" method="get">
										<input type="hidden" name="uid" value="${user.getUserID()}">
										<button type="submit" class="btn btn-danger"
											>Sửa</button>
									</form>
									 |
									<form action="/BTLWEB_N13/admin/user/delete" method="get">
										<input type="hidden" name="userID" value="${user.getUserID()}">
										<button type="submit" class="btn btn-danger"
											onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
									</form>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>