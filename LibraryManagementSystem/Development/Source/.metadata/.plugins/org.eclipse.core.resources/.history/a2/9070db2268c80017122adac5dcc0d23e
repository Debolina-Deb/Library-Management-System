/**
 * 
 */
function validateform() {
		
		var error1 = document.getElementById("passwordError");
		var error2 = document.getElementById("confirmPasswordError");
		var password = document.getElementById("password").value;
		error1.innerHTML = "";
		error2.innerHTML = "";
		var confirmPassword = document.getElementById("repeatPassword").value;

		if (password != confirmPassword) {
			error2.innerHTML = "Password Does Not Match"
		}
		if (error1.innerHTML.length > 0 || error2.innerHTML.length > 0)
			return false;
		else
			return true;

	}