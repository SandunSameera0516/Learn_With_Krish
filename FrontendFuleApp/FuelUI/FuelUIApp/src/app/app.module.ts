import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FuelOrdersComponent } from './fuel-orders/fuel-orders.component';
import { FuelOrdersService } from './fuel-orders/fuel-orders.service';
import { CreateFuelOrderComponent } from './create-fuel-order/create-fuel-order.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreateFuelOrderComponent,
    FuelOrdersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [FuelOrdersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
