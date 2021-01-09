import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { UserComponent } from './components/user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { LoginPageComponent } from './components/login-page/login-page.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListComponent } from './components/product-list/product-list.component';
import { BsNavbarComponent } from './components/bs-navbar/bs-navbar.component';
import { BsFooterComponent } from './components/bs-footer/bs-footer.component';
import { RegisterPageComponent } from './register-page/register-page.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductCategoryMenuComponent,
    ProductListComponent,
    ProductDetailsComponent,
    CartDetailsComponent,
    UserComponent,
    LoginPageComponent,
    BsNavbarComponent,
    BsFooterComponent,
    RegisterPageComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, NgbModule],
  providers: [ProductService],
  bootstrap: [AppComponent],
})
export class AppModule {}
