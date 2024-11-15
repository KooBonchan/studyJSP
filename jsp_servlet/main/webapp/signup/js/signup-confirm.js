/**
 * 
 */
const submit = document.getElementById('submit');
const cancel = document.getElementById('cancel');


submit.addEventListener('click', e => {
	alert("DB not implemented");
	history.back();
	
});

cancel.addEventListener('click', e => {
	history.back();
});