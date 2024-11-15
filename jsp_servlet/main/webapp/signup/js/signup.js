const form = document.getElementById('form');
const id = document.getElementById('id');
const password = document.getElementById('password');
const verify = document.getElementById('verify');
const email = document.getElementById('email');
const username = document.getElementById('username');
const birthday = document.getElementById('birthday');

const submit = document.getElementById('submit');
const reset = document.getElementById('reset');

const idRegex = /^(?=.*[a-zA-Z])[\w]{4,12}$/ 
const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,16}$/;

function raiseError(what, message){
	alert(message);
    what.value = "";
    what.focus();
}


function check(regex, what, message) {
    if(regex.test(what.value)) {
        return true;
    }
    raiseError(what, message);
    return false;
}

submit.addEventListener('click', e => {
  e.preventDefault();
  if( ! check(idRegex, id, "ID: 4~12 alphabet or number")){
	  return;
  }
  if( ! check(passwordRegex, password, "Password: 8~16, at least 1 lowercase, 1 uppercase, 1 number, 1 special character of [!@#$%^&*]")){
	  return;
  }
  
  if( password.value != verify.value ){
	raiseError(verify, "Verify and Password mismatches")
    return;  
  }
  if( name.value == ""){
  	raiseError(name, "No name");
  	return;
  }
  form.submit();
});

reset.addEventListener('click', e => {
	form.reset();
});