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

// ẩn/ hiện todo action 
const btnActionTodoList = document.querySelector('.nut__hanhdong__todo');
const listActionTodo = document.querySelector('.danhsach__hanhdong__todo');
btnActionTodoList.addEventListener('click', () => {
  listActionTodo.classList.toggle('hide');
});
// END TASK

// Click chỉnh sửa todo list
const listTask = document.querySelectorAll(".danhsach__chitiet__todo")
const editTask = document.querySelectorAll(".chinhsua__todo")
const btnEditTask = document.querySelectorAll(".icon__chinhsua__todo")
btnEditTask.forEach((item, index) => {
	item.addEventListener('click', () => {
		listTask.forEach((task, indexTask) => {
			if(index === indexTask) {
				task.classList.add("hide")
			}
		})
		editTask.forEach((edit, indexEdit) => {
			if(index === indexEdit) {
				edit.classList.add("show")
				edit.classList.remove("hide")
			}
		})
	})
})
// END TASK

// Chỉnh sửa todo list
const btnEditCancel = document.querySelectorAll(".chinhsua__btn__huybo")
btnEditCancel.forEach((item, index) => {
	item.addEventListener("click", () => {
		listTask.forEach((task, indexTask) => {
			if(index === indexTask) {
				task.classList.remove("hide")
			}
		})
		editTask.forEach((edit, indexEdit) => {
			if(index === indexEdit) {
				edit.classList.remove("show")
				edit.classList.add("hide")
			}
		})
	})
})
//END TASK

    
    
    
    
    
    