// XỬ LÝ PHẦN SETTING
// Thay đổi thời gian của Pomodoro, Short Break, Long Break

const giatri_pomodoro = document.querySelector('#pomodoro')
const giatri_shortBreak = document.querySelector('#short__break')
const giatri_longBreak = document.querySelector('#long__break')
const nut_submit_caidat = document.querySelector('.caidat__phancuoi')
const test = document.querySelector(".phandau__thuhai__thoigian--chu")
const click_thoigian_pomodo = document.querySelector('.thoigian_pomodo');
const click_thoigian_shortBreak = document.querySelector('.thoigian-nghi-ngan');
const click_thoigian_longBreak = document.querySelector('.thoigian-nghi-dai');
const caidat = document.querySelector('.phandau__caidat');
giatri_pomodoro.value = 25
giatri_shortBreak.value = 5
giatri_longBreak.value = 15


const handleCountDown = (value) => {
	let str_giatri
    if(value < 10 ) {
    	str_giatri = value.toString();
    	str_giatri = "0" +str_giatri + ":00";
    	
    	//Công thức
    } else {
     str_giatri = value.toString();
    	str_giatri = str_giatri + ":00";
    	
    	
    }
    return str_giatri
  }
// Xử lý các cài đặt trong mục setting 
// Cập nhập thay đổi các giá trị của các giá trị thời gian khi nhấn OK
nut_submit_caidat.addEventListener("click", () => {
	
	if(click_thoigian_pomodo.classList.contains("active")){
		test.innerHTML = handleCountDown(giatri_pomodoro.value);
	}
	else if(click_thoigian_shortBreak.classList.contains("active")){
		test.innerHTML = handleCountDown(giatri_shortBreak.value);
	}
	else{
		test.innerHTML = handleCountDown(giatri_longBreak.value);
	}
	
	
})



click_thoigian_pomodo.addEventListener("click" , () => {
			test.innerHTML = handleCountDown(giatri_pomodoro.value);
	})
	click_thoigian_shortBreak.addEventListener("click" , () => {
		test.innerHTML = handleCountDown(giatri_shortBreak.value);
	})
	click_thoigian_longBreak.addEventListener("click" , () => {
		test.innerHTML = handleCountDown(giatri_longBreak.value);
			})
			
			

// Thay đổi chế độ Dark Mode khi chạy
const nut_thaydoi_darknight = document.querySelector('.mautoi div');
const darknigth_phandau = document.querySelector('.phandau');
const nut_check = document.querySelector('.nut-chuyendoi')
const nut_next = document.querySelector('.nut_next');
const nut_start_pause = document.querySelector('.batdau__thoigian')
const tao_nhiemvu = document.querySelector('.tao__nhiemvu');
const them_todolist = document.querySelector('.them__todolist');
const phankhung_thoigian = document.querySelector('.phandau__thuhai__thoigian__taptrung')
const thanh_dieuhuong = document.querySelector('.danhsach__thoigian__lamviec');



nut_thaydoi_darknight.addEventListener("click", function(){
	
	if(nut_check.classList.contains("active")){
		nut_check.classList.remove("active");
		
		
		
	}else{
			nut_check.classList.add("active");
			
			
			
	}
	
})
nut_start_pause.addEventListener("click", function(){
	const nut_start_pause_chu = document.querySelector('.phandau__thuhai__nut button').textContent;
	if(nut_check.classList.contains("active") && nut_start_pause_chu ==="PAUSE"){
		darknigth_phandau.style.backgroundColor = "black";
			them_todolist.style.display = "none";
			tao_nhiemvu.style.display = "none";
			phankhung_thoigian.style.backgroundColor = "transparent";
			darknigth_phandau.style.color = "rgb(170, 170, 170)";
			thanh_dieuhuong.style.display = "none";
			nut_start_pause.style.boxShadow = "none";
			nut_start_pause.style.backgroundColor = "black";
			nut_start_pause.style.color = "rgb(170, 170, 170)";
			nut_next.style.display = "block";
			darknigth_phandau.style.transition ="background-color 2s ease-in-out";
	}
	
	else{
		darknigth_phandau.style.backgroundColor = "rgb(186, 73, 73)";
		them_todolist.style.display = "block";
		tao_nhiemvu.style.display = "block";
		phankhung_thoigian.style.backgroundColor = "var(--bgr-btn-2)";
		darknigth_phandau.style.color = "white";
		thanh_dieuhuong.style.display = "flex";
		nut_start_pause.style.boxShadow = "rgb(235 235 235) 0px 6px";
		nut_start_pause.style.backgroundColor = "white";
		nut_start_pause.style.color = "var(--text-color-first);";
		nut_next.style.display = "none";
		darknigth_phandau.style.transition ="background-color 2s ease-in-out";
		
	}
});

