<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="a" class="org.btlweb.dao.TodoListDAO" scope="request"></jsp:useBean>

<div class="baocao__noidung baocao__chitiet hide">
	<div class="baocao__noidung__title" style="margin-bottom: 5px">
		<p>TodoList Details</p>
		<div></div>
	</div>
	<div class="baocao__noidung__chitiet">
		<c:set var="ids" value="${sessionScope.UserID}" />
		<div class="chitiet__todolist--ten">
			<p>Name</p>
			<c:forEach items="${a.getAllTodoList(ids)}" var="item">
				<p style="font-weight: unset;">${item.getTodoName()}</p>
			</c:forEach>
		</div>
		<div class="chitiet__todolist--ngaytao">
			<p>Create At</p>
			<c:forEach items="${a.getAllTodoList(ids)}" var="item">
				<p style="font-weight: unset">${item.getCreateAt()}</p>
			</c:forEach>
		</div>
		<div class="chitiet__todolist--ngayhoanthanh">
			<p>End At</p>
			<c:forEach items="${a.getAllTodoList(ids)}" var="item">
				<p style="font-weight: unset">${item.getEndAt()}</p>
			</c:forEach>
		</div>
		<div class="chitiet__todolist--trangthai">
			<p>Status</p>
			<c:forEach items="${a.getAllTodoList(ids)}" var="item">
				<p style="font-weight: unset">${item.getStatus()}</p>
			</c:forEach>
		</div>
	</div>
	<div>
		<canvas id="myChart" width="400" height="400"></canvas>
	</div>
	
</div>