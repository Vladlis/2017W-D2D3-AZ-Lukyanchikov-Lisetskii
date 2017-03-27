This is a CRUD application for users.

Usage
-
- add user with name Bob: `curl -i -X POST http://localhost:8080/user/Bob`
- get user with id 0: `curl -i -X GET http://localhost:8080/user/0`
- replace user with id 0 to Jay: `curl -i -X PUT http://localhost:8080/user/0/Jay`
- delete user with id 0: `curl -i -X DELETE http://localhost:8080/user/0`
