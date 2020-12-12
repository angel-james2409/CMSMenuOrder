import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './Order';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }
  httpOrdersFetch():Observable<Order[]>{
    return this.http.get<Order[]>("http://localhost:8080/MLPXX/api/order/orderList");
    
  }
  insertOrder(menuId,quantity):Observable<string>{
     
    return this.http.post<string>("http://localhost:8080/MLPXX/api/order/insertnew/"+menuId+"/"+quantity,{});
  }

}
