// export class Orders {
// orderId:number;
// customerId:number;
// vendorId:number;
// orderStatus:string;
// orderTotalamount:number;
// orderQuantity:number;
// }


import { Time } from "@angular/common";

export class Order{
    id:number;
    orderStatus:string;
    customerId:number;
    totalAmount:number;
    quantity:number;
    menuId:number;
    //estimatedDeliveryTime:Date;
}
