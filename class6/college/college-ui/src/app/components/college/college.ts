import { Component } from '@angular/core';
import { Course } from '../course/course';
import { Student } from '../student/student';
import { Enrollment } from '../enrollment/enrollment';

@Component({
  selector: 'ncu-college',
  imports: [Course, Student, Enrollment],
  templateUrl: './college.html',
  styleUrl: './college.css'
})
export class College {

    constructor()
  {
    // Constructor logic if needed
  }

  ngOnInit(): void 
  {
    // Initialize data or fetch from a service

  }
  
}
