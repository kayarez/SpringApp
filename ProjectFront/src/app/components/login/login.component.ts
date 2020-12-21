import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  user = {username: '', password: '', repeatPassword: ''};

  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
  }

  login(): void{
    this.userService
      .login(this.user.username, this.user.password)
      .subscribe(() => {
        this.router
          .navigate(['/events']);
    });
  }
}
