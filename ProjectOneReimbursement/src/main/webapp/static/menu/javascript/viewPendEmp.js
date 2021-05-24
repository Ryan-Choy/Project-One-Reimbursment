viewPend();

function viewPend(){
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewPendingByEmp";
	xhr.open("GET",url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let pendList = xhr.getResponseHeader("pendingList");
			let pendJSON = JSON.parse(pendList);
			
		
			

			
			let content = document.getElementById("pendList")
			
			for(i = 0; i < pendJSON.length; i++){
					let reimtype = "";
				switch(Number(pendJSON[i].typeId)){
				case 1:
				reimtype = "Lodging";
				
				break;
				case 2:
				reimtype = "Travel";
				break;
				case 3:
				reimtype = "Food";
				break;
				case 4:
				reimtype = "Other";
				break;
				default:
				break;
				
			}
				let request ="<td>" + pendJSON[i].reimbId + "</td><td>" + pendJSON[i].amount + "</td><td>" + new Date(pendJSON[i].dateSubmitted).toString()  + "</td><td>" + pendJSON[i].description + "</td><td>" + pendJSON[i].author + "</td><td>" + reimtype + "</td>";
				content.insertAdjacentHTML('beforeend',request);
			}
	} else if(xhr.readyState==4){
					alert("Failed to load your pending reimbursements! Please check your login status.");
	}

}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User",token);
	xhr.send();
	
document.getElementById("back").addEventListener("click", back);
	function back(){
    window.location.href="http://localhost:8080/ProjectOneReimbursement/employee";
}
}