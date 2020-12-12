import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule  } from '@angular/common/http';


import { AppComponent } from './app.component';

import { MenuService } from 'src/app/menu/menu.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { OrderService } from 'src/app/order/order.service';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes:Routes=[
  
  {path:"",redirectTo:"welcome",pathMatch:"full"},
  {path:"welcome",component:WelcomeComponent},
  {path:"menu",component:MenuComponent},
  {path:"order",component:OrderComponent},

];
@NgModule({
  declarations: [
    AppComponent,
    
  
    MenuComponent,
    
  
    OrderComponent,
    
  
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [MenuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
