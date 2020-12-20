import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/common/product';
import { ProductCategory } from 'src/common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  private baseUrl = 'http://localhost:8080/api/category/'

  constructor(private httpClient: HttpClient) { }

  getProductCategoryById(theCategoryId: number): Observable<ProductCategory> {

    //@Todo: url based on catergory id .. will come back to this! (baseUrl)

    return this.httpClient.get<ProductCategory>(this.baseUrl+theCategoryId);
  }
}
