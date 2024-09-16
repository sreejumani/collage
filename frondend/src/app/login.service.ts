import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient){}
  getAllSubject(): Observable<object>{
    return this.http.get('http://localhost:8005/api/home/getAllsubject');

  }
  getSubjectByRollno(id: any): Observable<any> {
    return this.http.get<any>('http://localhost:8005/api/home//getSubject/{rollno}');
  }

  updateSubject(student: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8005/api/home/updateSubject/${student.rollno}`, student);
    
  }
}
export interface Student {
  rollno: number;
  name: string;
  marks: number;
}