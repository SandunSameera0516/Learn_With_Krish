import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class FuelOrdersComponent implements OnInit {

  orders?: any[];;
  isdispatch: boolean = false;
  // http2?:HttpClient;

  constructor(private http: HttpClient){
    
    http.get<any>('http://localhost:8083/api/v1/dispatch/get-all').subscribe(response =>{
      this.orders = response;
      // stock = this.stocks[0];
      // console.log(this.orders);
    });
  }

  updateOrder(id: HTMLTableCellElement){
    let post = {isdispatch:this.isdispatch,id:id};
    console.log(post);
    this.http.post('http://localhost:8083/api/v1/dispatch/update-dispatch',post).subscribe(response => {
      window.location.reload();
    });
  }

  ngOnInit(): void {
  }

}