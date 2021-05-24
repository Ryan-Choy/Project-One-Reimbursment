viewEmp();

function viewEmp(){
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewAllEmp";
	xhr.open("GET",url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let empList = xhr.getResponseHeader("allEmp");
			let empJSON = JSON.parse(empList);
			


			
			let content = document.getElementById("empList")
			
			for(i = 0; i < empJSON.length; i++){
				let request ="<td>" + empJSON[i].userId + "</td><td>" + empJSON[i].userName + "</td><td>" + empJSON[i].firstName +" "+ empJSON[i].lastName+"</td><td>"+ empJSON[i].email+"</td>";
				content.insertAdjacentHTML('beforeend',request);
			}
	} else if(xhr.readyState==4){
					alert("Failed to load the employees! Please check your login status.");
	}

}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User",token);
	xhr.send();
	
document.getElementById("back").addEventListener("click", back);
	function back(){
    window.location.href="http://localhost:8080/ProjectOneReimbursement/manager";
}
}