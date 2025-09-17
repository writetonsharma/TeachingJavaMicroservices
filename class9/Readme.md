This is a working spring sample to demonstrate multiple services doing CRUD operations.
Course and enrollment services are indepdent services. Student service is depending on course and enrollments for more data.
Code uses JDBC and mysql.
There are DB scripts in data folder. Run them in mysql and then run all three services. Call the endpoints to learn how things are working.
Student services calls enrollment and course services. You can look inside StudentService.java for how that is being done.


## class 9
Creates a local configuration server with security.