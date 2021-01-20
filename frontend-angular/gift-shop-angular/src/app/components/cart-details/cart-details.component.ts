import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css'],
})
export class CartDetailsComponent implements OnInit {
  cartItems: any[] = [];

  constructor(private cartService: CartService) {
    this.cartService.cart.subscribe(
      (cartItems) => (this.cartItems = cartItems)
    );
  }

  removeProduct(productId: number) {
    this.cartService.removeProduct(productId);
  }

  ngOnInit(): void {}
}
