import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'subject';
  students: any;

  constructor(private _loginService: LoginService, private router: Router) {}
  ngOnInit() {
    this.getAllSubject();
  }

  getAllSubject(): void {
    this._loginService.getAllSubject().subscribe(data => {
      console.log(data);
      this.students = data;
    });
  }
}
