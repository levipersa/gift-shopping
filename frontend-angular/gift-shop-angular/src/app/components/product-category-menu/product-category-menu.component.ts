import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductCategoryService } from 'src/app/services/product-category.service';
import { Product } from 'src/common/product';
import { ProductCategory } from 'src/common/product-category';

@Component({
  selector: 'app-product-category-menu',
  templateUrl: './product-category-menu.component.html',
  styleUrls: ['./product-category-menu.component.css']
})
export class ProductCategoryMenuComponent implements OnInit {

  category: ProductCategory;
  productsByCategory: Product[];
  currentCategoryId: number;

  constructor(private productCategoryService: ProductCategoryService,
              private route: ActivatedRoute) 
              { }

  ngOnInit() {
    this.route.paramMap.subscribe( () => {
    this.getCategory()
  });
}

  getCategory(){

    //check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id')

    if (hasCategoryId){
      //get the "id" param string. convert string to a number using the "+" symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')
    }
    else{
      //category id not found default is 1
      this.currentCategoryId = 1;
    }
    

    this.productCategoryService.getProductCategoryById(this.currentCategoryId).subscribe(
      data => {
        this.category = data;
        
     this.productsByCategory = this.category.products;
      }
    )
  }
}
