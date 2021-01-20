import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css'],
})
export class BsNavbarComponent implements OnInit {
  loggedIn = false;
  itemsQuantity: number;
  constructor(
    private authService: AuthService,
    private cartService: CartService
  ) {
    this.cartService.cart.subscribe(
      (cartItems) => (this.itemsQuantity = cartItems.length)
    );
    this.authService.loggedInUser.subscribe((loggedIn) => {
      this.loggedIn = loggedIn;
    });
  }

  logOut() {
    this.authService.logOut();
  }

  ngOnInit(): void {}
}
