import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/common/product';

@Injectable({
  providedIn: 'root',
})
export class ProductDetailsService {
  private baseUrl = 'http://localhost:8080/api/product/';

  constructor(private httpClient: HttpClient) {}

  getProductById(theProductId: number): Observable<Product> {
    //@Todo: url based on catergory id .. will come back to this! (baseUrl)

    return this.httpClient.get<Product>(this.baseUrl + theProductId);
  }
}
