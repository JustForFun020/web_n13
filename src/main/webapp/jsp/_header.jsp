<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <button class="nut__tuchon">
              <img src="../images/threedots-icon.png" alt="" />
            </button>
          </div>
          <div class="them__nhiemvu">
            <button class="nut__tuchon">
              <img src="../images/plus-circle-icon.png" alt="" style="width: 18px; opacity: 0.8; margin-right: 8px" />
              Add Task
            </button>
          </div>
        </div>
        <!-- Header Setting -->
        <jsp:include page="_setting.jsp"></jsp:include>
      </header>
</body>
</html>