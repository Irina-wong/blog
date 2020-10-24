## Read Me

This is a project of a blog web applocation. 

### Code Structure

#### Java.com.blogIn

- config: global configuration for security
- controller: controller for administrater, user, blog, catalog and vote.
- dao: entity of authority, blog, user, catalog, comment, vote and elastic search.
- repository: interfaces
- service: interfaces and implements of services
- util: exception handler
- vo: entity classes related to front end

#### resources

- static: js files and CSS files
- template: front end html files

### API
Following shows API of some functionalities.

#### User Management

- /users: GET 
Get user list
	- async: is the request asynchronous or not
	- pageIndex
	- pageSize
	- name: keywords of user name

- /users: POST
Save user

##### Register

- /register: GET 
Get the registratoin page
- /register: POST 
Registration, jump to login page when it's successful

##### Log In

##### Add User

- /users/add: GET
Get the page of new user

##### Edit User

- /users/edit/{id}: GET
Get the edit page of a specific user

##### Delete User

- /users/{id}: DELETE
Delete user

##### Search User

