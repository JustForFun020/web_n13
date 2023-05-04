<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pomodoro Timer Online - Pomofocus</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet"
    />
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="stylesheet" href="../css/headerStyle.css" />
    <link rel="stylesheet" href="../css/bodyStyle.css" />
    <link rel="stylesheet" href="../css/footer.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
</head>
<body>
	<main class="main">
      <!-- Header -->
      <header class="header">
        <!-- Header First -->
        <div class="hearder__first">
          <div class="header__first__logo">
            <img src="../images/icon-white2.png" alt="pomofocus-icon" class="header__pomofocus--icon" />
            <div class="header__pomofocus--text">
              <h3>Pomofocus</h3>
            </div>
          </div>

          <!-- Header First Navbar -->
          <div class="header__first__navbar">
            <ul class="header__navbar__list">
              <li class="navbar__list--btn">
                <button class="btn--report" onclick="handleLogin()">
                  <span>
                    <img src="../images/report-icon.png" alt="setting-icon" />
                  </span>
                  <span class="btn--text">Report</span>
                </button>
              </li>
              <li class="navbar__list--btn">
                <button class="btn--setting">
                  <span>
                    <img src="../images/setting-icon.png" alt="setting-icon" />
                  </span>
                  <span class="btn--text">Setting</span>
                </button>
              </li>
              <li class="navbar__list--btn">
                <button class="btn--login" id="login" onclick="handleClickLogin()">
                  <span>
                    <img src="../images/user-icon.png" alt="setting-icon" />
                  </span>
                  <span class="btn--text">Login</span>
                </button>
              </li>
            </ul>
          </div>
        </div>

        <!-- Header Second -->
        <div class="hearder__second">
          <!-- Header Second Time Focus -->
          <div class="header__second__time_focus">
            <div class="header__second__navbar">
              <ul class="list__time__work">
                <li class="time_pomodo active">
                  <button class="btn__custom active setup-type-time">Pomodoro</button>
                </li>
                <li class="time_short--break">
                  <button class="btn__custom setup-type-time">Short Break</button>
                </li>
                <li class="time_long--break">
                  <button class="btn__custom setup-type-time">Long Break</button>
                </li>
              </ul>
            </div>

            <!-- Header Second Time -->
            <div class="header__second__time">
              <h1 class="header__second__time--text" id="time__focus">25:00</h1>
            </div>

            <!-- Header Second Button -->
            <div class="header__second__btn">
              <button class="start__time" onclick="handleCountDownTime()">START</button>
            </div>
          </div>

          <!-- Header Second List Task -->
          <div class="header__second__list_task">
            <p style="font-size: 16px; opacity: 0.6; margin-bottom: 0; cursor: pointer">#0</p>
          </div>

          <!-- Header Second Text -->
          <div class="header__second__text">
            <p style="text-align: center; font-size: 18px; font-weight: 400">Time to focus!</p>
          </div>
        </div>

        <!-- Header Third -->
        <div class="hearder__third">
          <!-- Create Task -->
          <div class="create__task">
            <p style="font-size: 18px; margin: 0; font-weight: bold">Tasks</p>
            <button class="btn__custom">
              <img src="../images/threedots-icon.png" alt="" />
            </button>
          </div>
          <div class="add__task">
            <button class="btn__custom">
              <img src="../images/plus-circle-icon.png" alt="" style="width: 18px; opacity: 0.8; margin-right: 8px" />
              Add Task
            </button>
          </div>
        </div>
        <div class="header__setting hide">
          <div class="setting">
            <div style="display: flex; justify-content: space-between; align-items: center">
              <div class="setting__title">Setting</div>
              <img src="../images/close-icon.png" alt="" class="btn--close--setting" />
            </div>
            <div class="setting__config">
              <div class="setting__config_timer">
                <div class="timer--title">
                  <img src="../images/clock-icon.png" alt="" />
                  TIMER
                </div>
                <div class="timer--config">
                  <div class="timer--config-first">
                    <div class="text">
                      <span>Time (minutes)</span>
                    </div>
                    <ul class="set--time">
                      <li>
                        <form action="">
                          <label for="pomodoro">Pomodoro</label>
                          <input type="number" id="pomodoro" value="25" />
                        </form>
                      </li>
                      <li>
                        <form action="">
                          <label for="short__break">Short Break</label>
                          <input type="number" id="short__break" value="5" />
                        </form>
                      </li>
                      <li>
                        <form action="">
                          <label for="long__break">Long Break</label>
                          <input type="number" id="long__break" value="15" />
                        </form>
                      </li>
                    </ul>
                  </div>
                  <ul class="timer--config-second">
                    <li>
                      <span>Auto Start Breaks</span>
                      <div class="btn-toggle">
                        <div class="circle-wrapper">
                          <div class="circle"></div>
                        </div>
                      </div>
                    </li>
                    <li>
                      <span>Auto Start Pomodoros</span>
                      <div class="btn-toggle">
                        <div class="circle-wrapper">
                          <div class="circle"></div>
                        </div>
                      </div>
                    </li>
                    <li>
                      <span>Long Break Interval</span>
                      <div class="btn-toggle">
                        <div class="circle-wrapper">
                          <div class="circle"></div>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="space"></div>
                <div class="timer--title">
                  <img src="../images/check-icon.png" alt="" />
                  TASK
                </div>
                <ul class="timer--config-second">
                  <li>
                    <span>Auto Switch Tasks</span>
                    <div class="btn-toggle">
                      <div class="circle-wrapper">
                        <div class="circle"></div>
                      </div>
                    </div>
                  </li>
                </ul>
                <div class="space"></div>
                <div class="timer--title">
                  <img src="../images/sound-icon.png" alt="" />
                  SOUND
                </div>
                <ul class="timer--config-third">
                  <li>
                    <span>Alarm Sound</span>
                    <div style="text-align: right">
                      <select class="form-select">
                        <option selected>Kitchen</option>
                        <option value="1">Bell</option>
                        <option value="2">Bird</option>
                        <option value="3">Digital</option>
                        <option value="3">Wood</option>
                      </select>
                      <div style="margin: 25px 0">
                        <span id="value__first"></span>
                        <input type="range" class="form-range" id="customRange1" />
                      </div>
                      <div>
                        <label for="config--sound" style="margin-right: 10px; opacity: 0.8; font-size: 17px"
                          >repeat</label
                        >
                        <input type="number" id="config--sound" value="1" style="width: 55px" />
                      </div>
                    </div>
                  </li>
                  <li style="margin-top: 25px">
                    <span>Ticking Sound</span>
                    <div style="text-align: right">
                      <select class="form-select">
                        <option selected>None</option>
                        <option value="1">Ticking Fast</option>
                        <option value="2">Ticking Slow</option>
                        <option value="3">White Noise</option>
                        <option value="3">Brow Noise</option>
                      </select>
                      <div style="margin: 25px 0">
                        <span id="value__first2"></span>
                        <input type="range" class="form-range" id="customRange2" />
                      </div>
                    </div>
                  </li>
                </ul>
                <div class="space"></div>
                <div class="setting__details_theme">
                  <div class="title_setting timer--title">
                    <img src="../images/theme-icon.png" alt="" />
                    THEME
                  </div>
                  <ul class="list__theme_setting">
                    <li class="color-theme">
                      <span>Color Themes</span>
                      <div class="list-change-color">
                        <div class="chose-color" style="background-color: rgb(186, 73, 73)"></div>
                        <div class="chose-color" style="background-color: rgb(56, 133, 138)"></div>
                        <div class="chose-color" style="background-color: rgb(57, 112, 151)"></div>
                      </div>
                    </li>
                    <li class="hour-format">
                      <span>Hour format</span>
                      <div style="width: 130px" class="setting-hour">
                        <select class="select--hour">
                          <option selected>24-hour</option>
                          <option value="1">12-hour</option>
                        </select>
                      </div>
                    </li>
                    <li class="dark-mode">
                      <span>Dark Mode when running</span>
                      <div class="btn-toggle">
                        <div class="circle-wrapper">
                          <div class="circle"></div>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="space"></div>
                <div class="setting__details_other">
                  <div class="title_setting timer--title">
                    <img src="../images/config-icon.png" alt="" />
                    OTHERS
                  </div>
                  <ul class="list_other_setting">
                    <li class="noti-setting" style="align-items: center">
                      <span style="color: var(--text-color-6); font-weight: bold; align-items: center"
                        >Notification</span
                      >
                      <div class="chose-noti">
                        <select name="" id="">
                          <option value="1" selected>Every</option>
                          <option value="2">Last</option>
                        </select>
                        <input type="number" value="5" />
                        <span>min</span>
                      </div>
                    </li>
                    <li class="small-window" style="align-items: center; cursor: pointer">
                      <span style="color: var(--text-color-6); font-weight: bold">Small Window</span>
                      <div style="font-size: 15px">
                        Launch
                        <img src="../images/external-link-icon.svg" alt="" style="width: 12px" />
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="space"></div>
                <div class="setting__details_integration">
                  <div class="title_setting timer--title">
                    <img src="../images/integration-icon.png" alt="" />
                    INTEGRATION
                  </div>
                  <div class="integration">
                    <div class="information" style="color: var(--text-color-6); font-weight: bold">
                      TodoList
                      <img
                        src="../images/information-icon.png"
                        alt=""
                        style="width: 14px; transform: translateY(2px); opacity: 0.4"
                      />
                    </div>
                    <div class="setting-connect" style="width: 104px; font-size: 15px; cursor: pointer; margin: 0">
                      Connect
                      <img src="../images/lock-icon.png" alt="" style="width: 12px" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="setting__footer">
              <button>OK</button>
            </div>
          </div>
        </div>
      </header>
      <div class="body">
        <div class="body__title">
          <h1>An online Pomodoro Timer to boost your productivity</h1>
        </div>
        <div class="body__content content__first">
          <div class="content__text">What is Pomofocus?</div>
          <div class="content__space"></div>
          <div class="content__detail">
            Pomofocus is a customizable pomodoro timer that works on desktop & mobile browser. The aim of this app is to
            help you focus on any task you are working on, such as study, writing, or coding. This app is inspired by
            <a href="https://francescocirillo.com/products/the-pomodoro-technique" target="_blank"
              >Pomodoro Technique</a
            >
            which is a time management method developed by Francesco Cirillo.
          </div>
        </div>
        <div class="body__content content__second">
          <div class="content__text">What is Pomodoro Technique?</div>
          <div class="content__space"></div>
          <div class="content__detail">
            The Pomodoro Technique is created by Francesco Cirillo for a more productive way to work and study. The
            technique uses a timer to break down work into intervals, traditionally 25 minutes in length, separated by
            short breaks. Each interval is known as a pomodoro, from the Italian word for 'tomato', after the
            tomato-shaped kitchen timer that Cirillo used as a university student. -
            <a href="https://en.wikipedia.org/wiki/Pomodoro_Technique" target="_blank">Wikipedia</a>
          </div>
        </div>
        <div class="body__content content__third">
          <div class="content__text">How to use the Pomodoro Timer?</div>
          <div class="content__space"></div>
          <ul class="content__list content__detail">
            <li class="content__list_details">1. <strong>Add tasks</strong> to work on today</li>
            <li class="content__list_details">
              2. <strong>Set estimate pomodoros</strong> (1 = 25min of work) for each tasks
            </li>
            <li class="content__list_details">3. <strong>Select a task</strong> to work on</li>
            <li class="content__list_details">4. <strong>Start timer</strong> and focus on the task for 25 minutes</li>
            <li class="content__list_details">5. <strong>Take a break</strong> for 5 minutes when the alarm ring</li>
            <li class="content__list_details">6. <strong>Iterate</strong> 3-5 until you finish the tasks</li>
          </ul>
        </div>
        <div class="body__content content__fourth">
          <div class="content__text">Features</div>
          <div class="content__space"></div>
          <ul class="content__list content__detail">
            <li class="content__list_details"><strong>Responsive design</strong> that works with desktop and mobile</li>
            <li class="content__list_details">
              <strong>Color transition</strong> o switch moods between work time and rest time
            </li>
            <li class="content__list_details"><strong>Audio notification</strong> at the end of a timer period</li>
            <li class="content__list_details"><strong>Customizable timer</strong> intervals to suit your preference</li>
          </ul>
        </div>
        <div class="body__content content__fifth">
          <div class="content__text">Download App</div>
          <div class="content__space"></div>
          <ul class="content__list content__detail">
            <li class="content__list_details">
              <strong style="color: var(--text-color-4)">For macOS</strong> (zip file) *Right click the icon to open
            </li>
            <li class="content__list_details">
              <strong style="color: var(--text-color-4)">For Windows</strong>(file zip)
            </li>
          </ul>
        </div>
      </div>
      <footer class="footer">
        <div class="footer__sitmap" style="margin-bottom: 14px">
          <ul class="footer__navbar">
            <li class="footer__navbar_list">
              <a href="#">HOME</a>
            </li>
            <li class="footer__navbar_list">
              <a href="./component/sitmap/pravicy.html" target="_blank">PRAVICY</a>
            </li>
            <li class="footer__navbar_list">
              <a href="#">CONTACT</a>
            </li>
            <li class="footer__navbar_list">
              <a href="./component/sitmap/simplePage.html" target="_blank">SIMPLE PAGE</a>
            </li>
          </ul>
        </div>
        <div class="footer__snslink">
          <img src="../images/facebook-icon.png" alt="facebook" />
          <img src="../images/twitter-icon.png" alt="twitter" />
          <img src="../images/stripe-climate-badge-icon.png" alt="strip climate" />
        </div>
        <div class="footer__content">
          Made by
          <strong style="color: var(--text-color-4); opacity: 0.7">N13_WEB</strong>
        </div>
        <div class="footer__about">©Pomofocus 2023. All Rights Reserved.</div>
      </footer>
    </main>
        <script src="../js/script.js"></script>
</body>
</html>