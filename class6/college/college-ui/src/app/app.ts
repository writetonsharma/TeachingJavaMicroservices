import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { College } from './components/college/college';
import { Student } from './components/student/student';

@Component({
  selector: 'ncu-root',
  imports: [RouterOutlet, College, Student],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('college-ui');
}
