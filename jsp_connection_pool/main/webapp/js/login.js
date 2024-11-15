/**
 * 
 */
const formLogin = document.formLogin;
function validateForm(){
	let idElement = formLogin.id;
	let passwordElement = formLogin.password;
	let id = idElement.value;
	let password = passwordElement.value;
	if( id.length == 0 ||
		id == "" ||
		password.length == 0 ||
		password == ""){
			alert("ID and Password are mandatory.");
			return;
		}
	formLogin.method = "post";
	formLogin.action = "login";
	formLogin.submit();
}