// Xử lý đếm ngược khi click button START
let countdownInterval;
let isCountdownRunning = false;
function handleCountDownTime() {
  if (isCountdownRunning) {
    clearInterval(countdownInterval);
    isCountdownRunning = false;
  } else {
    let time = document.getElementById('time__focus').innerHTML;
    let timeArray = time.split(':');
    let minutes = timeArray[0];
    let seconds = timeArray[1];

    countdownInterval = setInterval(function () {
      seconds--;
      if (seconds < 0) {
        minutes--;
        seconds = 59;
      }
      if (minutes < 0) {
        clearInterval(countdownInterval);
        alert('Countdown finished!');
      } else {
        document.getElementById('time__focus').innerHTML =
          minutes.toString().padStart(2, '0') + ':' + seconds.toString().padStart(2, '0');
      }
    }, 1000);
    isCountdownRunning = true;
  }
}
let countClickStart = 0;
const btnStart = document.querySelector('.batdau__thoigian');
btnStart.addEventListener('click', () => {
  setTimeout(() => {
    countClickStart++;
    btnStart.textContent = countClickStart % 2 === 0 ? 'START' : 'PAUSE';
  }, 1000);
});
// END Task

// Input slide
const value = document.querySelector('#value__first');
const input = document.querySelector('#customRange1');
value.textContent = input.value;
input.addEventListener('input', (event) => {
  value.textContent = event.target.value;
});

const value2 = document.querySelector('#value__first2');
const input2 = document.querySelector('#customRange2');
value2.textContent = input2.value;
input2.addEventListener('input', (event) => {
  value2.textContent = event.target.value;
});
// END Task

const btnToggle = document.querySelectorAll('.nut-chuyendoi');
const circleWrapper = document.querySelectorAll('.vongtron-baoboc');
const circle = document.querySelectorAll('.vongtron');
let clickCount = 0;
btnToggle.forEach((item, index1) => {
  item.addEventListener('click', () => {
    circle.forEach((item, index2) => {
      if (index1 === index2) {
        item.classList.toggle('circle--active');
      }
    });
    circleWrapper.forEach((item, index3) => {
      if (index1 === index3) {
        item.classList.toggle('vongtron-baoboc--active');
      }
    });
  });
});
//END Task

// Xử lý hiện và ẩn tab setting
const btnSetting = document.querySelector('.nut--caidat');
const btnCloseSetting = document.querySelector('.nut--dong--caidat');
const settingContainer = document.querySelector('.phandau__caidat');
const bodyContainer = document.querySelector('.phanthan');
const footerContainer = document.querySelector('.phancuoi');
const wrapper = document.querySelector('.baoboc__ungdung');

btnSetting.addEventListener('click', () => {
  settingContainer.classList.add('show');
  settingContainer.classList.add('scroll--overflow');
  bodyContainer.classList.add('hide');
  footerContainer.classList.add('hide');
  wrapper.classList.add('hide--overflow');
});
btnCloseSetting.addEventListener('click', () => {
  settingContainer.classList.remove('show');
  settingContainer.classList.remove('scroll--overflow');
  settingContainer.classList.add('hide');
  bodyContainer.classList.remove('hide');
  footerContainer.classList.remove('hide');
  wrapper.classList.remove('hide--overflow');
});
// END Task

// Active kiểu thời gian(Pomodoro, Long Break, Short Break)
let timeIndex = 0;
const timePomodoro = document.querySelector('.thoigian_pomodo');
const timeShortBreak = document.querySelector('.thoigian-nghi-ngan');
const timeLongBreak = document.querySelector('.thoigian-nghi-dai');
const listTypeOfTime = document.querySelectorAll('.caidat-kieu-thoigian');
// background color: đỏ:(186, 73, 73) xanh lá:(56, 133, 138) xánh dương:(57, 112, 151)
listTypeOfTime.forEach((item, index) =>
  item.addEventListener('click', () => {
    // item.style.backgroundColor = 'red';
    listTypeOfTime.forEach((otherItem) => {
      otherItem.classList.remove('active');
    });
    item.classList.add('active');
    if (index === 0) {
      timePomodoro.classList.add('active');
      timeLongBreak.classList.remove('active');
      timeShortBreak.classList.remove('active');
    } else if (index === 1) {
      timePomodoro.classList.remove('active');
      timeLongBreak.classList.remove('active');
      timeShortBreak.classList.add('active');
    } else {
      timePomodoro.classList.remove('active');
      timeLongBreak.classList.add('active');
      timeShortBreak.classList.remove('active');
    }
  })
);
// END Task
