<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="u" class="org.btlweb.dao.UserDAOIMPL" scope="request"></jsp:useBean>
<jsp:useBean id="a" class="org.btlweb.dao.TodoListDAO" scope="request"></jsp:useBean>
<div class="baocao__noidung baocao__tonghop show">
	<div class="tonghop__hoatdong">
		<div class="tonghop__hoatdong__title">
			<p>Activity Summary</p>
			<div></div>
		</div>
		<form action="" class="tonghop__hoatdong--form">
			<div class="sogio__taptrung--form">
				<c:set var="hourFocus" value="${sessionScope.hourFocus}" />
				<div>
					<img alt="" src="https://pomofocus.io/icons/clock-red.png" />
					<p class="sogio">${hourFocus}</p>
				</div>
				<p>hours focus</p>
			</div>
			<div class="dangnhap__lientiep--form">
				<c:set var="streak" value="${sessionScope.streak}" />
				<div>
					<img src="https://pomofocus.io/icons/flame-red.png" alt="" />
					<p class="songay">${streak}</p>
				</div>
				<p>day streak</p>
			</div>
		</form>
	</div>
	<div class="tonghop__todolist">
		<div class="tonghop__todolist__title">
			<p>TodoList Summary</p>
			<div></div>
		</div>
		<div class="todolist__chitiet">
			<c:set var="ids" value="${sessionScope.UserID}" />
			<div class="ten__todolist">
				<p style="font-weight: bold;  margin-bottom: 5px">Name</p>
				<c:forEach items="${a.getAllTodoList(ids)}" var="item">
					<div style="display: flex; width: 200px;">
						<c:choose>
							<c:when test="${item.getStatus().equals('Done')}">
								<span style="color: #54B435" class="ten__todolist">${item.getTodoName()}</span>
							</c:when>
							<c:otherwise>
								<span style="color: #FF8787" class="ten__todolist">${item.getTodoName()}</span>
							</c:otherwise>
						</c:choose>			
					</div>
				</c:forEach>
			</div>
			<div class="trangthai__todolist">
				<p style="font-weight: bold; margin-bottom: 5px">Status</p>
				<c:forEach items="${a.getAllTodoList(ids)}" var="item">
					<div style="display: flex; width: 200px;">
						<c:choose>
							<c:when test="${item.getStatus().equals('Done')}">
								<span style="color: #54B435" class="trangthai__todolist">${item.getStatus()}</span>
							</c:when>
							<c:otherwise>
								<span style="color: #FF8787" class="trangthai__todolist">${item.getStatus()}</span>
							</c:otherwise>
						</c:choose>	
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="khoangcach"></div>
		<div class="todolist__tongket">
			<div>
				<p>Total:</p>
				<p id="totalValue"></p>
			</div>
			<div>
				<p>Hoàn thành:</p>
				<p id="doneValue">${doneTodo}</p> 
			</div>
			<div>
				<p>Chưa hoàn thành:</p>
				<p id="inProcessValue">${inProcessTodo}</p> 
			</div>
		</div>
	</div>
</div>