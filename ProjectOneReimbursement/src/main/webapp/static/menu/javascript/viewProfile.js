viewProfile();

function viewProfile() {
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewProfile";
	xhr.open("GET", url);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let profile = xhr.getResponseHeader("userProfile");
			let proJSON = JSON.parse(profile);

			let name = document.getElementById("name");
			name.innerText = "Name: "+proJSON.firstName +" "+ proJSON.lastName;
			
			let id = document.getElementById("id");
			id.innerText = "ID: "+String(proJSON.userId);
			
			let username = document.getElementById("username");
			username.innerText = "Username: "+proJSON.userName;
			
			let password = document.getElementById("password");
			password.innerText = "Password: "+ proJSON.password;
			
			
			let email = document.getElementById("email");
			email.innerText = "Email: "+proJSON.email;
			
			let show = document.getElementById("show");
			show.addEventListener("click", showPW);
			function showPW(){
			if(password.style.display === "none"){
			
				password.style.display = "inline";
			} else if(password.style.display === "inline"){
				password.style.display = "none";
			}
			}

		
		} else if (xhr.readyState == 4) {
			alert("Failed to load your profile! Please check your login status.");
		}

	}
	

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User", token);
	xhr.send();

	document.getElementById("back").addEventListener("click", back);
	function back() {
		window.location.href = "http://localhost:8080/ProjectOneReimbursement/employee";
	}
}
