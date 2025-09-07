import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { College } from './components/college/college'

@Component({
  selector: 'ncu-root',
  imports: [RouterOutlet, College],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('CollegeUI');
}
