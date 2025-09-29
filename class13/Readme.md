This is a working spring sample to demonstrate multiple services doing CRUD operations.
Course and enrollment services are indepdent services. Student service is depending on course and enrollments for more data.
Code uses JDBC and mysql.
There are DB scripts in data folder. Run them in mysql and then run all three services. Call the endpoints to learn how things are working.
Student services calls enrollment and course services. You can look inside StudentService.java for how that is being done.


## class 13
Adds basic authentication on all services.
api gateway is also secure and needs to be authenticated.
auth service is written which signs up new user and authenticate existing users.
api gateway authenticate with auth service. a custom filter is written which disables basic authentication and does the authentication by calling auth service.
Then gets the credentials for downstream services as well as adds a secret header.
downstream service uses basic auth and validates the secret header.