const loginForm = document.querySelector("#loginForm");

const EMAIL_REQUIRED = "Please enter your email.";
const PASSWORD_REQUIRED = "Please enter your password.";

if(loginForm){
    loginForm.addEventListener("submit", function(event){
        event.preventDefault();
    
        let emailValid = hasValue(form.elements["email"], EMAIL_REQUIRED);
        let passwordValid = hasValue(form.elements["password"], PASSWORD_REQUIRED);
    
        if (emailValid && passwordValid) {
            alert("Demo only. No form was posted.");
        }
    });
}

function hasValue(input, message) {
	if (input.value.trim() === "") {
		return showError(input, message);
	}
	return showSuccess(input);
}

function showError(input, message) {
	return showMessage(input, message, false);
}

function showSuccess(input) {
	return showMessage(input, "", true);
}

function showMessage(input, message, type) {
	// get the small element and set the message
	const msg = input.parentNode.querySelector("small");
	msg.innerText = message;
	// update the class for the input
	input.className = type ? "success" : "error";
	return type;
}