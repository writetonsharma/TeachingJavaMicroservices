import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { College } from './components/college/college';
import { Course } from './components/course/course';
import { Enrollment } from './components/enrollment/enrollment';
import { Student } from './components/student/student';


@Component({
  selector: 'ncu-root',
  imports: [RouterOutlet, Course, Enrollment, Student, College],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('college-ui');
}
