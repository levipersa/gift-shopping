import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductDetailsService } from 'src/app/services/product-details.service';
import { Product } from 'src/common/product';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
})
export class ProductDetailsComponent implements OnInit {
  product: Product;
  currentProductId: number;

  constructor(
    private productDetailsService: ProductDetailsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.getProduct();
    });
  }

  getProduct() {
    const hasProductId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasProductId) {
      this.currentProductId = +this.route.snapshot.paramMap.get('id');
    } else {
      this.currentProductId = 1;
    }

    this.productDetailsService
      .getProductById(this.currentProductId)
      .subscribe((data) => {
        this.product = data;
        console.log(data);
      });
  }
}
