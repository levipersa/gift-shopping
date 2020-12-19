import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductListComponent } from './components/product-list/product-list.component';

const routes: Routes = [

  
  { path: 'category/:id', component: ProductCategoryMenuComponent },
  { path: 'product/:id', component: ProductDetailsComponent },
  { path: 'cart', component: CartDetailsComponent },
  { path: 'product', component: ProductDetailsComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'home', component: ProductListComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home', pathMatch: 'full' },


];

@NgModule({
  imports: [NgbModule,
    RouterModule.forRoot(routes)
            
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
