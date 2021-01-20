import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from 'src/common/product';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  cartItems = [];
  cart = new BehaviorSubject([]);

  constructor() {
    if (localStorage.getItem('cart')) {
      this.cartItems = JSON.parse(localStorage.getItem('cart'));
      this.cart.next(this.cartItems);
    }
  }

  addProduct(product: Product) {
    const existingProduct = this.cartItems.find(
      (item) => item.id === product.id
    );

    if (existingProduct) {
      existingProduct.quantity++;
    } else {
      this.cartItems.push({
        id: product.id,
        quantity: 1,
        product: product,
      });
    }
    this.cart.next(this.cartItems);
    this.persistCart();
    console.log(this.cartItems);
  }

  removeProduct(productId: number) {
    this.cartItems = this.cartItems.filter(
      (cartItem) => cartItem.id !== productId
    );
    this.cart.next(this.cartItems);
    this.persistCart();
  }

  persistCart() {
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
  }
}
