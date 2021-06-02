# PROJECT NAME

## Project Description

The employee reimbursement system is an application that allows employees to submit requests to the company to be reimbursed for money spent while working. Employees can login, see the employee homepage, view their pending and resolved reimbursement requests, submit new requests under the categories of Lodging, Travel, Food, and Other, view their profiles, and edit their username, password, and email.
Finance managers can login, view all reimbursement requests, view the past history for all employees, and are authorized to approve or deny requests for reimbursement.

## Technologies Used

- Java 8
- Maven
- Log4J
- PostgreSQL
- Tomcat
- Javascript
- HTML 5
- AWS EC2/RDS/S3

## Features

List of features ready and TODOs for future development

- Employees and Managers can log in and log out.
- Employees can view their created requests for expense reimbursement.
- Employees can submit a new reimbursement request.
- Employees can view and edit their information.
- Managers can view all pending requests for expense reimbursement from all employees.
- Managers can view all resolved requests from all employees.
- Managers can view an employee's history.
- Managers can view all employees's.

To-do list:

- Employees can upload pictures of their receipt as part of their request.
- Employees will recieve an email when one of their reimbursement requests is resolved.
- Managers can view uploaded images

## Getting Started

1. Install Git Bash, Java 8, Tomcat, DBeaver, and Maven.

2. run git clone https://github.com/Ryan-Choy/Project-One-Reimbursment.git in git bash

3. Set up a database connection in DBeaver.

4. Run mvn clean package in git bash inside the project folder.

5. Create a tomcat server, version 8.5

6. Add the project resource to the tomcat server

7. Start the Tomcat Server.

- Images of what it should look like

## Usage

> Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.


Upon connecting to localhost:8080/ProjectOneReimbursement you should arrive to the front page.
![Front page](/images/frontpage.png)


Clicking the login button will take you to the login page, here, you will enter your username and password to log in.
![Login page](/images/login.png)

You will then be taken to the employee page or manager page in which you can click on the buttons to be taken to the appropriate page. 

![Employee page](/images/employee.png)

![Manager page](/images/manager.png)