import { Injectable } from '@angular/core';
import { ICourse, ICourseOptions } from '../../Models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  
  CourseOptions: ICourseOptions[];
  selectedItem: string;
  

  constructor()
  {
    this.selectedItem = "";

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

}
