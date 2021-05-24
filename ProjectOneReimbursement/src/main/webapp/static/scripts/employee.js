//Ensure that the token has the right authorization

let token = sessionStorage.getItem("token");

//If not the right token or has the right authorization, redirect to the appropriate

if(!token){
	window.location.href="http://localhost:8080/ProjectOneReimbursement";
} else{
	
	let uType = token.split(":");
	if(uType.length === 4){
		//redirect to manager if manager
		switch(Number(uType[1])){
			case 1:
			//employee
			let greet = document.getElementById("greet");
			greet.innerText = "Welcome Employee " + uType[2]+" "+uType[3]+" to the ERS."
			
			break;
			
			case 2:
			window.location.href="http://localhost:8080/ProjectOneReimbursement/manager";
			break;
			
			default:
			window.location.href="http://localhost:8080/ProjectOneReimbursement/error";
			break;
			
			
		}
		
		
	}
}
document.getElementById("viewPend").addEventListener("click", viewPend);
document.getElementById("viewRes").addEventListener("click", viewRes);
document.getElementById("submit").addEventListener("click", submit);
document.getElementById("viewProfile").addEventListener("click", viewProfile);
document.getElementById("updateProfile").addEventListener("click", updateProfile);
document.getElementById("logout").addEventListener("click", logout);


function viewPend(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewPendEmp";

}
function viewRes(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewResEmp";

}

function submit(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/submit";

}
function viewProfile(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewInfo";

}

function updateProfile(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/updateInfo";

}

function logout(){
		window.location.href="http://localhost:8080/ProjectOneReimbursement/logout";

}


