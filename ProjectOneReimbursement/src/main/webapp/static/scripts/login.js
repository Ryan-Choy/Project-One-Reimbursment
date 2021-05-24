/**
 * 
 */
let aTok = localStorage.getItem("token");

loged();

function loged(){
	if(aTok != null){
		let tokArray = aTok.split(":");
		switch(Number(tokArray[1])){
				case 1:
				//redirect to employee
				window.location.href="http://localhost:8080/ProjectOneReimbursement/employee"
				break;
			
				case 2:
				window.location.href="http://localhost:8080/ProjectOneReimbursement/manager"
				break;
				
				default:
				window.location.href="http://localhost:8080/ProjectOneReimbursement/error"

				break;
		}
	}
}



document.getElementById("login-btn").addEventListener("click", requestLogin);

function requestLogin(){
	
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	
	let xhr = new XMLHttpRequest();
	
	//sends a post request
	let url = "http://localhost:8080/ProjectOneReimbursement/login";
	xhr.open("POST", url);


	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let use = xhr.getResponseHeader("User");
			/*
				session is a storage that lasts for that specific page session(tab)
				here we store our auth token
			*/
			sessionStorage.setItem("token", use);
			/*
				if the login is successful, redirects to employee or manager
			*/
			
			let userType = sessionStorage.getItem("token").split(":")
			
			//determine which kind of user is it
			switch(Number(userType[1])){
				
				case 1:
				//redirect to employee
				window.location.href="http://localhost:8080/ProjectOneReimbursement/employee"
				break;
			
				case 2:
				window.location.href="http://localhost:8080/ProjectOneReimbursement/manager"
				break;
				
				default:
				document.getElementById('message').innerHTML='Something went wrong!';
				break;
				
			}
			
		} 
		else if (xhr.readyState == 4){
			document.getElementById('message').innerHTML='Incorrect credentials!';
		}
	}
	
	/*
		Allows us to send form data as a single block in the body rather than as query params in the URL
	*/
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}