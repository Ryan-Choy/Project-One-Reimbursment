
document.getElementById("submit").addEventListener("click", submit);
document.getElementById("back").addEventListener("click", back);

function submit(){
	let amount = document.getElementById("amount").value;
	let type = document.getElementById("type").value;
    let description = document.getElementById("description").value;
	let token = sessionStorage.getItem("token");
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/submitReim";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully submited your reimbursement request! You can now return to the main menu or submit another request.");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to submit your reimbursement, please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `amount=${amount}&type=${type}&description=${description}`;
	xhr.setRequestHeader("User",token);
	xhr.send(requestBody);
}

function back(){
    window.location.href="http://localhost:8080/ProjectOneReimbursement/employee";
}
