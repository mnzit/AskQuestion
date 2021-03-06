import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";


  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  authenticate() {
    this.authService.login(this.username, this.password).subscribe(data => {
      localStorage.setItem("token", data);
      this.router.navigate(["/user/questions"]);
     
    });
  }
}
