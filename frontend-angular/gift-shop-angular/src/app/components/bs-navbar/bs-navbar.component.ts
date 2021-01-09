import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css'],
})
export class BsNavbarComponent implements OnInit {
  loggedIn = false;

  constructor(private authService: AuthService) {
    this.authService.loggedInUser.subscribe((loggedIn) => {
      this.loggedIn = loggedIn;
    });
  }

  logOut() {
    this.authService.logOut();
  }

  ngOnInit(): void {}
}
