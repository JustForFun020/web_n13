// xử lý ẩn, hiện todoList

const btnAddTask = document.querySelector('.them__nhiemvu');
const addTaskDetails = document.querySelector('.them__nhiemvu__chitiet');
const btnCancelAddTask = document.querySelector('.nut--huy--them__nhiemvu');
btnAddTask.addEventListener('click', () => {
  btnAddTask.classList.remove('show');
  btnAddTask.classList.add('hide');
  addTaskDetails.classList.remove('hide');
  addTaskDetails.classList.add('show');
});

btnCancelAddTask.addEventListener('click', () => {
  btnAddTask.classList.remove('hide');
  btnAddTask.classList.add('show');
  addTaskDetails.classList.add('hide');
  addTaskDetails.classList.remove('show');
});

const btnAddNote = document.querySelector('.nut--them__ghichu');
const areaAddNote = document.querySelector('#o--them__ghichu');
btnAddNote.addEventListener('click', () => {
  areaAddNote.classList.remove('hide');
  areaAddNote.classList.add('show');
  btnAddNote.classList.add('hide');
});

// END TASK