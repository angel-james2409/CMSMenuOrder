import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Menu} from './Menu';


@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http:HttpClient) { }
  httpMenuFetch():Observable<Menu[]>{
    return this.http.get<Menu[]>("http://localhost:8080/MLPXX/api/menu/menuList");
    
  }
}
