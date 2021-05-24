document.getElementById("check").addEventListener("click", viewRes);


function viewRes() {
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewAllReqByEmp";
	let eId = document.getElementById("empId").value;
	xhr.open("GET", url);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let resList = xhr.getResponseHeader("allReqEmp");
			let resJSON = JSON.parse(resList);



			let content = document.getElementById("empList")

			for (i = 0; i < resJSON.length; i++) {
				let reimtype = "";
				switch (Number(resJSON[i].typeId)) {
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

				let statustype = "";
				switch (Number(resJSON[i].statusId)) {
					case 1:
						statustype = "Pending";
						break;
					case 2:
						statustype = "Approved";
						break;
					case 3:
						statustype = "Denied";
						break;
					default:
						break;

				}
				let request = "<td>" + resJSON[i].reimbId + "</td><td>" + resJSON[i].amount + "</td><td>" + new Date(resJSON[i].dateSubmitted).toString() + "</td><td>" + new Date(resJSON[i].dateResolved).toString() + "</td><td>" + resJSON[i].description + "</td><td>" + resJSON[i].author + "</td><td>" + resJSON[i].resolver + "</td><td>" + statustype + "</td><td>" + reimtype + "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
		} else if (xhr.readyState == 4) {
			alert("Failed to load the employee's requests! Please check your login status.");
		}

	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User", token);
	xhr.setRequestHeader("empId", eId);
	xhr.send();
}
document.getElementById("back").addEventListener("click", back);
function back() {
	window.location.href = "http://localhost:8080/ProjectOneReimbursement/manager";
}




