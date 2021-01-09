import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError, map, repeat, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/api/login';
  loggedInUser = new BehaviorSubject(false);

  constructor(private httpClient: HttpClient) {
    if (localStorage.getItem('token')) {
      this.loggedInUser.next(true);
    }
  }

  login(credentials: any): Observable<boolean> {
    return this.httpClient.post(this.loginUrl, credentials).pipe(
      tap((response: any) => {
        localStorage.setItem('token', response.token);
        this.loggedInUser.next(true);
      }),
      map(() => true),
      catchError(() => of(false))
    );
  }

  logOut() {
    localStorage.removeItem('token');
    this.loggedInUser.next(false);
  }
}
