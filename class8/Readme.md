This is a working spring sample to demonstrate multiple services doing CRUD operations.
Course and enrollment services are indepdent services. Student service is depending on course and enrollments for more data.
Code uses JDBC and mysql.
There are DB scripts in data folder. Run them in mysql and then run all three services. Call the endpoints to learn how things are working.
Student services calls enrollment and course services. You can look inside StudentService.java for how that is being done.


## class 8
In this Angular tutorial, we move beyond static content and dive into dynamic features of Angular. You’ll learn how to use powerful constructs like ngModel, ngIf, ngFor, and ngModelChange to make your application interactive.

We’ll also create a service class and see how to call it from a component, which is a key concept in Angular for building scalable applications.

What you’ll learn in this video:
✔️Using ngModel for two-way data binding
✔️Controlling UI with ngIf (conditional rendering)
✔️Displaying lists dynamically with ngFor
✔️Handling input changes with ngModelChange
✔️Creating a service class in Angular
✔️Injecting and using a service in a component

By the end of this tutorial, you’ll understand how to make your Angular components dynamic and reusable, setting a strong foundation for real-world applications.