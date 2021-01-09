import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/api/login';

  constructor(private httpClient: HttpClient) {}

  login(credentials: any) {
    this.httpClient
      .post(this.loginUrl, credentials)
      .subscribe((response) => console.log(response));
  }
}
