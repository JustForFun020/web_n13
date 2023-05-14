/**
 * 
 */

const loginForm = document.querySelector("#form__dangnhap")
const account = document.querySelector("#taikhoan")
const password =document.querySelector("#matkhau") 
const errAccount = document.querySelector("#loi__taikhoan");
const errPassword = document.querySelector("#loi__matkhau");
const btnLogin = document.querySelector(".nut__dangnhap")

loginForm.addEventListener("submit", (e) => {
	e.preventDefault()
	if (account.value === '') {
        errAccount.innerHTML = "Tài khoản không được để trống";
    }

    // Tiếp tục thực hiện action của form nếu không có lỗi
    if (account.value !== '') {
        loginForm.submit();
    }
})