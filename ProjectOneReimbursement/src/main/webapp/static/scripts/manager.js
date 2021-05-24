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
			window.location.href="http://localhost:8080/ProjectOneReimbursement/employee";
			break;
			
			case 2:
			let greet = document.getElementById("greet");
			greet.innerText = "Welcome Manager " + uType[2]+" "+uType[3]+" to the ERS."
			
			break;
			
			default:
			window.location.href="http://localhost:8080/ProjectOneReimbursement/error";
			break;
			
			
		}
		
		
	}
}
document.getElementById("viewAllPend").addEventListener("click", viewAllPend);
document.getElementById("viewAllRes").addEventListener("click", viewAllRes);
document.getElementById("viewAllEmp").addEventListener("click", viewAllEmp);
document.getElementById("viewReqEmp").addEventListener("click", viewReqEmp);

document.getElementById("logout").addEventListener("click", logout);


function viewAllPend(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewPendList";

}
function viewAllRes(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewResList";

}

function viewAllEmp(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewEmpList";

}
function viewReqEmp(){
	window.location.href="http://localhost:8080/ProjectOneReimbursement/viewReqEmp";

}


function logout(){
		window.location.href="http://localhost:8080/ProjectOneReimbursement/logout";

}

