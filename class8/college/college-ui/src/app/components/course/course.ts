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
  course: ICourse;
  coursedto: ICourseDto;
  courseService: CourseService;
  selectedItem: string;


  constructor(cs: CourseService)
  {
    this.courseService = cs;
    this.selectedItem = "";

    this.course = {
      courseid: "",
      coursename: "",
      credits: 0
    };
      this.coursedto = {
      coursename: "",
      credits: 0
    };
  }

  getCourseOptions(): ICourseOptions[]
  {
    return this.courseService.getCourseOptions();
  }

  getSelectedItem(): string
  {
    return this.courseService.getSelectedItem();
  }

  onSelectionChange(value: string): void
  {
    this.selectedItem = value;
    this.courseService.onSelectionChange(this.selectedItem);
  }
}
