import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-fuel-stock.component.html',
  styleUrls: ['./add-fuel-stock.component.css']
})
export class AddFuelStockComponent implements OnInit {

  constructor(private http: HttpClient) { }

  createStock(availableStock: HTMLInputElement,allocatedAmount: HTMLInputElement){
    let post = {availableStock: availableStock.value,allocatedAmount:allocatedAmount.value};
    // console.log(post);
    this.http.post('http://localhost:8081/api/v1/allocation-check/update-stock',post).subscribe(response => {
      console.log(response);
    });
  }

  reloadPage(){
    window.location.reload();
  }

  ngOnInit(): void {
  }

}