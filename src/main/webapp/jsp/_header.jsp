<%@ page import="org.btlweb.model.TodoList" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<header class="phandau">
        <!-- Header First -->
        <div class="phandau__thunhat">
          <div class="phandau__thunhat__logo">
            <img src="../images/icon-white2.png" alt="pomofocus-icon" class="phandau__pomofocus--icon" />
            <div class="phandau__pomofocus--chu">
              <h3>Pomofocus</h3>
            </div>
          </div>

          <!-- Header First Navbar -->
          <div class="phandau__thunhat__thanhdieuhuong">
            <ul class="phandau__thanhdieuhuong__danhsach">
              <li class="thanhdieuhuong__danhsach--nut">
                <button class="nut--baocao" onclick="handleLogin()">
                  <span>
                    <img src="../images/report-icon.png" alt="setting-icon" />
                  </span>
                  <span class="nut--chu">Report</span>
                </button>
              </li>
              <li class="thanhdieuhuong__danhsach--nut">
                <button class="nut--caidat">
                  <span>
                    <img src="../images/setting-icon.png" alt="setting-icon" />
                  </span>
                  <span class="nut--chu">Setting</span>
                </button>
              </li>
              <li class="thanhdieuhuong__danhsach--nut">
              	<form action="${pageContext.request.contextPath}/jsp/login.jsp">
                	<button class="nut--dangnhap" id="login">
                  	<span>
                    	<img src="../images/user-icon.png" alt="setting-icon" />
                  	</span>
                  	<span class="nut--chu">Login</span>
                	</button>
              	</form>
              </li>
            </ul>
          </div>
        </div>

        <!-- Header Second -->
        <div class="phandau__thuhai">
          <!-- Header Second Time Focus -->
          <div class="phandau__thuhai__thoigian__taptrung">
            <div class="phandau__thuhai__thanhdieuhuong">
              <ul class="danhsach__thoigian__lamviec">
                <li class="thoigian_pomodo active">
                  <button class="nut__tuchon active caidat-kieu-thoigian">Pomodoro</button>
                </li>
                <li class="thoigian-nghi-ngan">
                  <button class="nut__tuchon caidat-kieu-thoigian">Short Break</button>
                </li>
                <li class="thoigian-nghi-dai">
                  <button class="nut__tuchon caidat-kieu-thoigian">Long Break</button>
                </li>
              </ul>
            </div>

            <!-- Header Second Time -->
            <div class="phandau__thuhai__thoigian">
              <h1 class="phandau__thuhai__thoigian--chu" id="time__focus">25:00</h1>
            </div>

            <!-- Header Second Button -->
            <div class="phandau__thuhai__nut">
              <button class="batdau__thoigian" onclick="handleCountDownTime()">START</button>
            </div>
            
            	
           
          </div>

          <!-- Header Second List Task -->
          <div class="phandau__thuhai__danhsach_nhiemvu">
            <p style="font-size: 16px; opacity: 0.6; margin-bottom: 0; cursor: pointer">#0</p>
          </div>

          <!-- Header Second Text -->
          <div class="phandau__thuhai__chu">
            <p style="text-align: center; font-size: 18px; font-weight: 400">Time to focus!</p>
          </div>
        </div>

        <!-- Header Third -->
        <div class="phandau__thuba">
          <!-- Create Task -->
          <div class="tao__nhiemvu">
            <p style="font-size: 18px; margin: 0; font-weight: bold">Tasks</p>
            <button class="nut__tuchon nut__hanhdong__todo">
              <img src="../images/threedots-icon.png" alt="" />
            </button>
            <ul class="danhsach__hanhdong__todo hide">
            	<li>
            		<a href="${pageContext.request.contextPath}/action-task?action=clear-finished-task">
            			<img style="margin-right: 5px" alt="" src="https://pomofocus.io/icons/delete-black.png">
            			<span>Clear finished task</span>
            		</a>
            	</li>
            	<li>
            		<a href="${pageContext.request.contextPath}/action-task?action=clear-inprocess-task">
            			<img style="margin-right: 5px" alt="" src="https://pomofocus.io/icons/delete-black.png">
            			<span>Clear in process task</span>
            		</a>
            	</li>
            	<li>
            		<a href="${pageContext.request.contextPath}/action-task?action=clear-all-task">
            			<img style="margin-right: 5px" alt="" src="https://pomofocus.io/icons/delete-black.png">
            			<span>Clear all task</span>
            		</a>
            	</li>
            	<li>
            		<a href="${pageContext.request.contextPath}/action-task?action=done-all-task"> 
            			<img style="margin-right: 5px" alt="" src="https://pomofocus.io/icons/clear-black.png"> 
						<span>Done all task</span>
					</a>
            	</li>
            </ul>
          </div>
          <div class="tatca__todo">
    		<c:forEach items="${a.getAllTodoList()}" var="item" >
        		<div class="danhsach__chitiet__todo">
        				<c:choose>
        					<c:when test="${item.getStatus().equals('Done')}">
        					<div class="chitiet__todo active__todo ">
        						<form class="chitiet__todo__thunhat form-trangthai-hoanthanh" action="${pageContext.request.contextPath}/edit-task?edit-action=change-inprocess-status" method="post">
        							<input name="chinhsua__todo__id" value="${item.getID()}" type="hidden" >
        							<input value="${item.getStatus()}" type="hidden" />
        							<button class="icon__todo__kiemtra nut-trangthai-hoanthanh">
	        							<img alt="" src="../images/inprocess-icon.png" >
    	    						</button>
	    	    					<span>${item.getTodoName()}</span>
        						</form>
        						<div  class="icon__chinhsua__todo" >
		        			<img alt="" src="../images/threedots-icon.png">       			
        				</div>
        						</div>
        					</c:when>
        					<c:when test="${item.getStatus().equals('In Process')}">
        					<div class="chitiet__todo">
        						<form class="chitiet__todo__thunhat form-trangthai-trongtientrinh" action="${pageContext.request.contextPath}/edit-task?edit-action=change-done-status" method="post"  >
        							<input name="chinhsua__todo__id" value="${item.getID()}" type="hidden" />
        							<input value="${item.getStatus()}" type="hidden" />
        							<button  class="icon__todo__kiemtra nut-trangthai-trongtientrinh">
	        							<img alt="" src="../images/icon-check-todo.png" >
    	    						</button>
	    	    					<span>${item.getTodoName()}</span>
        						</form>
        						<div  class="icon__chinhsua__todo" >
		        			<img alt="" src="../images/threedots-icon.png">       			
        				</div>
        						</div>
        					</c:when>
        				</c:choose>
        			<div class="ghichu__todo">
	        			<p>${item.getNote()}</p>
           			</div>
        		</div>
        		<div class="chinhsua__todo hide">
        			<div class="form__chinhsua__todo">
              			<form action="${pageContext.request.contextPath}/edit-task?edit-action=edit-update-task" method="post">
              				<input type="hidden" name="chinhsua__todo__id" value="${item.getID()}" />
                			<input type="text" placeholder="What are you working on?" name="chinhsua__todoName" value="${item.getTodoName() }"/>
                			<div class="chinhsua__thoigian__ketthuc">
                				<span>Hoàn thành trong :</span> <input name="chinhsua__endAt" placeholder="25" type="number" required/> <span>phút</span>
                			</div>
                			<textarea name="chinhsua__note" class="chinhsua__them__ghichu" rows="3" col="10" placeholder="Add Note">${item.getNote()}</textarea>
              				<div class="danhsach__todo__btn">
              					<div>
	                				<button type="button" class="chinhsua__btn__huybo">Cancel</button>
	              					<button class="chinhsua__btn__luu">Save</button>
              					</div>
              				</div>
             		 	</form>
             		 	<form style="position: absolute; bottom: 28px; left: 32px;" action="${pageContext.request.contextPath}/edit-task?edit-action=edit-delete-task" method="post">
	              			<input type="hidden" name="chinhsua__todo__id" value="${item.getID()}" />
	              			<button style="padding: 10px;" class="chinhsua__btn__xoa">Delete</button>
              			</form>
          			</div>
          		</div>
        	</c:forEach> 
          </div>
          <div class="them__todolist">
            <div class="them__nhiemvu">
              <button class="nut__tuchon">
                <img src="../images/plus-circle-icon.png" alt="" style="width: 18px; opacity: 0.8; margin-right: 8px" />
                Add Task
              </button>
            </div>
            <form class="them__nhiemvu__chitiet hide" method="POST" action="${pageContext.request.contextPath}/addtodolist">
              <div class="khung__them__nhiemvu">
                <input type="text" placeholder="What are you working on?" name="todoName" required/>
                <div class="thoigian__kethuc">
                	<span>Hoàn thành trong :</span> <input required name="endAt" placeholder="MM" type="number" /> <span>phút</span>
                </div>
                <button type="button" class="nut--them__ghichu">Add Note +</button>
                <textarea name="note" class="hide" id="o--them__ghichu" rows="3" placeholder="Add Note"></textarea>
              </div>
              <div class="them__nhiemvu__navbar">
                <button class="nut--them__nhiemvu" style="margin-left: 20px">Save</button>
                <button type="button" class="nut--huy--them__nhiemvu">Cancel</button>
              </div>
            </div>
          </form>
        </div>
        <!-- Header Setting -->
        <jsp:include page="_setting.jsp"></jsp:include>
        <!-- Header Report -->
        <jsp:include page="../jsp/report/index.jsp"></jsp:include>
      </header>
</body>
</html>