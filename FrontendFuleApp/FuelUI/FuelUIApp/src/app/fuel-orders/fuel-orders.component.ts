import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FuelOrdersService } from './fuel-orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './fuel-orders.component.html',
  styleUrls: ['./fuel-orders.component.css']
})
export class FuelOrdersComponent implements OnInit {

  orders?: any[];
  title = "List of Orders";
  
  constructor(http: HttpClient){
    
    http.get<any>('http://localhost:8080/api/v1/orders/get-all').subscribe(response =>{
      this.orders = response;
    });
  }

  ngOnInit(): void {
  }

}