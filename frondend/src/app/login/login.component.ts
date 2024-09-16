import { Component } from '@angular/core';
import { LoginService } from '../login.service';
import { Subject } from 'rxjs';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {
  students: any;
  editingIndex: number | null = null;
  //public form: FormGroup | undefined;
  //public newStudent: { rollno:string ;name: string; marks: string; } = { rollno:'' , name: '', marks: '' };

  constructor(private _loginService: LoginService) {}

  ngOnInit() {
    this.getAllSubject();
    
  }

  getAllSubject(): void {
    this._loginService.getAllSubject().subscribe( {
      next: (data) => this.students = data,
      error: (err) => console.error('Error loading students', err)
    });
  }
  editStudent(student: any, index: number): void {
    this.editingIndex = index;
    
    //  this.newStudent = { ...student }; 
    console.log('Editing student at index:', index, student);
  }

  submitChanges(): void {
    
    if (this.editingIndex !== null) {
      const student = this.students[this.editingIndex];
      this._loginService.updateSubject(student).subscribe({
        next: () => this.editingIndex = null,
        error: (err) => console.error('Error updating student', err)
      });
      console.log("editted successfully")
  }
  }
}