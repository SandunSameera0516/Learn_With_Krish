import { NgForOf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stock',
  templateUrl: './fuel-stock.component.html',
  styleUrls: ['./fuel-stock.component.css']
})
export class FuelStockComponent implements OnInit {

  stocks?: any[];;

  constructor(http: HttpClient){
    
    http.get<any>('http://localhost:8081/api/v1/allocation-check/get-all').subscribe(response =>{
      this.stocks = response;
      console.log(this.stocks);
    });
  }
  

  ngOnInit(): void {
  }

}