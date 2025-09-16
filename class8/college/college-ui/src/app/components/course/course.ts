import { Component } from '@angular/core';
import { ICourse, ICourseOptions } from '../../Models/course.model';
import { ICourseDto } from '../../Dtos/course.dto';
import { CourseService } from '../../services/course/course.service';
import {CommonModule, NgStyle} from '@angular/common'
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'ncu-course',
  imports: [CommonModule, NgStyle, FormsModule],
  templateUrl: './course.html',
  styleUrl: './course.css'
})
export class Course 
{
  Course: ICourse;
  CourseDto: ICourseDto;
  CourseService: CourseService;
  SelectedItem: string;


  constructor(cs: CourseService)
  {
    this.CourseService = cs;
    this.SelectedItem = "";

    this.Course = {
      courseId: "",
      courseName: "",
      credits: 0
    };
      this.CourseDto = {
      courseName: "",
      credits: 0
    };
  }

  getCourseOptions(): ICourseOptions[]
  {
    return this.CourseService.getCourseOptions();
  }

  getSelectedItem(): string
  {
    return this.CourseService.getSelectedItem();
  }

  onSelectionChange(value: string): void
  {
    this.SelectedItem = value;
    this.CourseService.onSelectionChange(this.SelectedItem);
  }
}
