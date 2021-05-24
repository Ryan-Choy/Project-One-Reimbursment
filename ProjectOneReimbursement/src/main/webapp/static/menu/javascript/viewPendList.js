viewAllPending();

function viewAllPending(){
	let token = sessionStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewAllPend";
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            let pendList = xhr.getResponseHeader("allPending");
			let pListJSON = JSON.parse(pendList);
			

			
			let content = document.getElementById("pendList");
				for(i = 0; i < pListJSON.length; i++){
					
			let reimtype = "";
			
			switch(Number(pListJSON[i].typeId)){
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
					
				let request ="<td>" + pListJSON[i].reimbId + "</td><td>" + pListJSON[i].amount + "</td><td>" + new Date(pListJSON[i].dateSubmitted).toString()  + "</td><td>" + pListJSON[i].description + "</td><td>" + pListJSON[i].author + "</td><td>" + reimtype + "</td>";
				content.insertAdjacentHTML('beforeend',request);
			}

		} 
		else if (xhr.readyState == 4){
			alert("Failed to load pending requests! Please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User",token);
	xhr.send();
}

document.getElementById("resolve").addEventListener("click", resolveReim);
document.getElementById("back").addEventListener("click", back);

function resolveReim(){
	let reimId = document.getElementById("reimId").value;
	let action = document.getElementById("action").value;

	let token = sessionStorage.getItem("token")
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/updateReim";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully resolved this reimbursement request!");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to resolved this reimbursement request! Please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User",token);
	let requestBody = `reimId=${reimId}&action=${action}`;
	xhr.send(requestBody);
}

function back(){

    window.location.href="http://localhost:8080/ProjectOneReimbursement/manager"

}
