## Read Me

### User Management

- /users: GET 
Get user list
	- async: is the request asynchronous or not
	- pageIndex
	- pageSize
	- name: keywords of user name

- /users: POST
Save user


#### Register

- /register: GET 
Get the registratoin page
- /register: POST 
Registration, jump to login page when it's successful

#### Log In

#### Add User

- /users/add: GET
Get the page of new user

#### Edit User

- /users/edit/{id}: GET
Get the edit page of a specific user

#### Delete User

- /users/{id}: DELETE
Delete user

#### Search User

