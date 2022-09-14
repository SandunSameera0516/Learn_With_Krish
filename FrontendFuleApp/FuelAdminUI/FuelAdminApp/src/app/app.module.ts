import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FuelStockComponent } from './fuel-stock/fuel-stock.component';
import { AddFuelStockComponent } from './add-fuel-stock/add-fuel-stock.component';
import { FormsModule } from '@angular/forms'; 
import { FuelOrdersComponent } from './fuel-orders/fuel-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    AddFuelStockComponent,
    FuelOrdersComponent,
    FuelStockComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }