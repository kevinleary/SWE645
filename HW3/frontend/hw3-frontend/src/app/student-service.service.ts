import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from './student';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class StudentService {

  private studentsUrl: string;

  constructor(private http: HttpClient) {
    this.studentsUrl = 'http://localhost:8080/students';
  }

  // public mapAll(): Observable<Student[]> {
  //   return this.http.get<Student[]>(`${this.studentsUrl}`)
  //   .pipe(map(response => response['results']));
  // }

  public findAll(): Observable<any> {
    return this.http.get<any>(this.studentsUrl)
  }

  public save(student: Student) {
    return this.http.post<Student>(this.studentsUrl, student);
  }
}