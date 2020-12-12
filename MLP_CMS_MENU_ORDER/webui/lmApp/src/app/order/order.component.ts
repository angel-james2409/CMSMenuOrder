import { Component, OnInit } from '@angular/core';
import { OrderService } from './order.service';
import { Order } from './Order';

@Component({
  selector: 'app-orders',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orderDetails:Order[];

  fid:number;
  qty:number;
  message:string;

  constructor(private orderservice:OrderService) { }


  ngOnInit(): void {
    this.orderservice.httpOrdersFetch().subscribe((data)=>this.orderDetails=data);

  }
  placeOrder(orderForm){
    this.fid=orderForm.value.fid;
    this.qty=orderForm.value.qty;
    //this.sum=this.sum+this.qty;
    console.log(this.fid);
    this.orderservice.insertOrder(this.fid,this.qty).subscribe((data)=>this.message=data);
    this.message="ORDER PLACED SUCCESSFULLY";

  }

}
