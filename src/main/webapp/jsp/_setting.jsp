<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<div class="phandau__caidat hide">
          <div class="caidat">
            <div
              style="
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid rgb(238, 238, 238);
              "
            >
              <div class="caidat__tieude">Setting</div>
              <img src="../images/close-icon.png" alt="" class="nut--dong--caidat" />
            </div>
            <div class="caidat__cauhinh">
              <div class="caidat__cauhinh_thoigian">
                <div class="thoigian--tieude">
                  <img src="../images/clock-icon.png" alt="" />
                  TIMER
                </div>
                <div class="thoigian--cauhinh">
                  <div class="thoigian--cauhinh-thunhat">
                    <div class="chu">
                      <span>Time (minutes)</span>
                    </div>
                    <ul class="thietlap--thoigian">
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
                  <ul class="thoigian--cauhinh-thuhai">
                    <li>
                      <span>Auto Start Breaks</span>
                      <div class="nut-chuyendoi">
                        <div class="vongtron-baoboc">
                          <div class="vongtron"></div>
                        </div>
                      </div>
                    </li>
                    <li>
                      <span>Auto Start Pomodoros</span>
                      <div class="nut-chuyendoi">
                        <div class="vongtron-baoboc">
                          <div class="vongtron"></div>
                        </div>
                      </div>
                    </li>
                    <li>
                      <span>Long Break Interval</span>
                      <div class="nut-chuyendoi">
                        <div class="vongtron-baoboc">
                          <div class="vongtron"></div>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="khoangcach"></div>
                <div class="thoigian--tieude">
                  <img src="../images/check-icon.png" alt="" />
                  TASK
                </div>
                <ul class="thoigian--cauhinh-thuhai">
                  <li>
                    <span>Auto Switch Tasks</span>
                    <div class="nut-chuyendoi">
                      <div class="vongtron-baoboc">
                        <div class="vongtron"></div>
                      </div>
                    </div>
                  </li>
                </ul>
                <div class="khoangcach"></div>
                <div class="thoigian--tieude">
                  <img src="../images/sound-icon.png" alt="" />
                  SOUND
                </div>
                <ul class="thoigian--cauhinh-thuba">
                  <li>
                    <span>Alarm Sound</span>
                    <div style="text-align: right">
                      <select class="form--luachon">
                        <option selected>Kitchen</option>
                        <option value="1">Bell</option>
                        <option value="2">Bird</option>
                        <option value="3">Digital</option>
                        <option value="3">Wood</option>
                      </select>
                      <div style="margin: 25px 0">
                        <span id="value__first"></span>
                        <input type="range" class="form--phamvi" id="customRange1" />
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
                      <select class="form--luachon">
                        <option selected>None</option>
                        <option value="1">Ticking Fast</option>
                        <option value="2">Ticking Slow</option>
                        <option value="3">White Noise</option>
                        <option value="3">Brow Noise</option>
                      </select>
                      <div style="margin: 25px 0">
                        <span id="value__first2"></span>
                        <input type="range" class="form--phamvi" id="customRange2" />
                      </div>
                    </div>
                  </li>
                </ul>
                <div class="khoangcach"></div>
                <div class="caidat__chitiet_chude">
                  <div class="tieude_caidat thoigian--tieude">
                    <img src="../images/theme-icon.png" alt="" />
                    THEME
                  </div>
                  <ul class="danhsach__chude_caidat">
                    <li class="mausac-chude">
                      <span>Color Themes</span>
                      <div class="danhsach-thaydoi-mausac">
                        <div class="chon-mausac" style="background-color: rgb(186, 73, 73)"></div>
                        <div class="chon-mausac" style="background-color: rgb(56, 133, 138)"></div>
                        <div class="chon-mausac" style="background-color: rgb(57, 112, 151)"></div>
                      </div>
                    </li>
                    <li class="gio-dinhdang">
                      <span>Hour format</span>
                      <div style="width: 130px" class="caidat-gio">
                        <select class="chon--gio">
                          <option selected>24-hour</option>
                          <option value="1">12-hour</option>
                        </select>
                      </div>
                    </li>
                    <li class="mautoi">
                      <span>Dark Mode when running</span>
                      <div class="nut-chuyendoi">
                        <div class="vongtron-baoboc">
                          <div class="vongtron"></div>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="khoangcach"></div>
                <div class="caidat__chitiet_khac">
                  <div class="tieude_caidat thoigian--tieude">
                    <img src="../images/config-icon.png" alt="" />
                    OTHERS
                  </div>
                  <ul class="danhsach_khac_caidat">
                    <li class="thongbao-caidat" style="align-items: center">
                      <span style="color: var(--text-color-6); font-weight: bold; align-items: center"
                        >Notification</span
                      >
                      <div class="chon-thongbao">
                        <select name="" id="">
                          <option value="1" selected>Every</option>
                          <option value="2">Last</option>
                        </select>
                        <input type="number" value="5" />
                        <span>min</span>
                      </div>
                    </li>
                    <li class="cuaso-nho" style="align-items: center; cursor: pointer">
                      <span style="color: var(--text-color-6); font-weight: bold">Small Window</span>
                      <div style="font-size: 15px">
                        Launch
                        <img src="../images/external-link-icon.svg" alt="" style="width: 12px" />
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="khoangcach"></div>
                <div class="caidat__chitiet_lienhop">
                  <div class="tieude_caidat thoigian--tieude">
                    <img src="../images/integration-icon.png" alt="" />
                    INTEGRATION
                  </div>
                  <div class="lienhop">
                    <div class="thongtin" style="color: var(--text-color-6); font-weight: bold">
                      TodoList
                      <img
                        src="../images/information-icon.png"
                        alt=""
                        style="width: 14px; transform: translateY(2px); opacity: 0.4"
                      />
                    </div>
                    <div class="caidat-ketnoi" style="width: 104px; font-size: 15px; cursor: pointer; margin: 0">
                      Connect
                      <img src="../images/lock-icon.png" alt="" style="width: 12px" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="caidat__phancuoi">
              <button>OK</button>
            </div>
          </div>
        </div>
</body>
</html>