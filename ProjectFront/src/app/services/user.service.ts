import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any>{
    const authHeader = this.createBasicAuthHttpHeader(username, password);
    const header = new HttpHeaders({
      Authorization: authHeader
    });
    return this.http
      .post('http://localhost:8080/rest/api/v1/login', {username, password})
      .pipe(map((data ) => {
        console.log(data);
        sessionStorage.setItem('username', username);
        sessionStorage.setItem('token', `${data["token"]}`);
        return data;
      }));
  }

  register(username: string, password: string, repeatPassword: string): Observable<any>{
    return this.http
      .post('http://localhost:8080/rest/api/v1/register', {username, password, repeatPassword})
      .pipe();
  }

  logout(): void{
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
  }

  public isUserLoggedIn(): boolean{
    return !(sessionStorage.getItem('authUser') === null);
  }

  createBasicAuthHttpHeader(login: string, password: string){
    return 'Basic ' + window.btoa(login + ':' + password);
  }

  getToken() {
    return sessionStorage.getItem('token');
  }

  getUser() {
    return sessionStorage.getItem('username');
  }
}
