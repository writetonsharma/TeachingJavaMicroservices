import { Injectable } from '@angular/core';
import { ICourse, ICourseOptions } from '../../Models/course.model';
import { CourseApiService } from './course.api.service';
import { ICourseDto } from '../../Dtos/course.dto';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  
  CourseOptions: ICourseOptions[];
  selectedItem: string;
  CourseApiService: CourseApiService;
  Courses: ICourseDto[];

  constructor(CourseApiService: CourseApiService)
  {
    this.CourseApiService = CourseApiService;
    this.selectedItem = "";
    this.Courses = [];

    this.CourseOptions = 
    [
      {id: 'getallcourses',
        value: 'Get all courses'},
      {id: 'getcoursebyname',
        value: 'Get course by name'},
      {id: 'getcoursebyid',
        value: 'Get course by id'},
      {id: 'addcourse',
        value: 'Add course'}
    ];
  }

  getCourseOptions(): ICourseOptions[]
  {
    return this.CourseOptions;
  }

  getSelectedItem(): string
  {
    return this.selectedItem;
  }

  onSelectionChange(value: string): void
  {
    this.selectedItem = value;
  }

  getAllCourses(): void
  {
    this.CourseApiService.getAllCourses().subscribe(courses => {
      this.Courses = courses;
    });
  }
  
  getCourses() : ICourseDto[] 
  {
    return this.Courses;
  } 

}
