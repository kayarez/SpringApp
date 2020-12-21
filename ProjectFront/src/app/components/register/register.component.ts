import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {
  user = {username: '', password: '', repeatPassword: ''};

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  register(): void{
    this.userService
      .register(this.user.username, this.user.password, this.user.repeatPassword)
      .subscribe(() => {
        this.router
          .navigate(['/login']);
    });
  }

}
