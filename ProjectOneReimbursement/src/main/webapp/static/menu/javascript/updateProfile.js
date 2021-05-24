
document.getElementById("submit").addEventListener("click", submit);
document.getElementById("back").addEventListener("click", back);

function submit(){
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
	let token = sessionStorage.getItem("token");
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/updateProfile";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully updated your profile! You can now return to the main menu or make more changes.");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to submit your update, please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${username}&password=${password}&email=${email}`;
	xhr.setRequestHeader("User",token);
	xhr.send(requestBody);
}

function back(){
    window.location.href="http://localhost:8080/ProjectOneReimbursement/employee";
}