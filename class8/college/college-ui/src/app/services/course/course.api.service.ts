import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICourseDto } from '../../Dtos/course.dto';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CourseApiService {
  
  http: HttpClient;

  constructor(http: HttpClient)
  {
    this.http = http;
  }

  getAllCourses(): Observable<ICourseDto[]> 
  {
    return this.http.get<ICourseDto[]>('http://localhost:9001/courses/');
  }
}
