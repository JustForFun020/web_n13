<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="a" class="org.btlweb.dao.TodoListDAO" scope="request"></jsp:useBean>
<jsp:useBean id="u" class="org.btlweb.dao.UserDAOIMPL" scope="request"></jsp:useBean>
<jsp:useBean id="r" class="org.btlweb.dao.ReportDAO" scope="request"></jsp:useBean>

<div class="baocao__noidung baocao__bangxephang hide">
	<div class="baocao__bangxephang__title">
		<p>Ranking</p>
		<div></div>
	</div>
	<div>
		<ul class="bangxephang__phandau">
			<li>Name</li>
			<li>Time Focus(Minutes)</li>
		</ul>
		<div class="bangxephang__phanthan">
			<ul class="bangxephang__phanthan__chitiet">
				<c:forEach var="user" items="${r.totalMinuteFocus()}">
					<li>
						<div class="thongtin__nguoidung">
							<span>${user.getUserName()}</span>
							<img src="${user.getImage()}" alt="" />
						</div>
						<div class="thongtin__sophut">
							<span>${user.getTotalFocus()}</span>
						</div>
					</li>
					<div class="khaongcach"></div>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>