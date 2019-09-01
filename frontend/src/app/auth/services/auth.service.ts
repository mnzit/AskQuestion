import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post("http://localhost:8080/api/v1/login", { username, password });
  }

  loggedInUser() {
    if (localStorage.getItem("token")) {
      return true;
    }
    return false;
  }
}
