# Getting Started

### Employee Service Reference Documentation
For further reference, please consider the following sections:

Edit application.properties file to set the database name (xyz_db) and password (XXXX).

Swagger API URL:- [http://localhost:8080/swagger-ui-employee.html](http://localhost:8080/swagger-ui-employee.html)

### 1. Create/ Add Employee API:
To create a new employee, send a POST request to the following endpoint:
* Endpoint: `/api/employees`
* Method: `POST`
* Request Body:  
{
  "name": "xyz mnl",
  "email": "ss@gmail.com",
  "company": "xyz pvt ltd",
  "department": "Development",
  "phone": "9090909090",
  "address": "204, xyz, Delhi.",
  "city": "New Delhi",
  "state": "Delhi",
  "country": "India",
  "zip": "202445",
  "designation": "Associate",
  "salary": 140.50,
  "dateOfJoining": "2019-08-20"
}
