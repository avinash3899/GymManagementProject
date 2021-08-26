import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GymserviceService } from '../gymservice.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  id!: number;
  response!:boolean;
  subscription!:string;
  paymentStatus!:string;
  cost!:number;
  sessionValueEmail!: any;
  message!:string;
  constructor(private service:GymserviceService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.sessionValueEmail=sessionStorage.getItem("email");
    if(this.sessionValueEmail==null){
      alert("Please login to continue");
      this.router.navigate(['gym/login']);
    }
    this.id = this.activatedRoute.snapshot.params['id'];
    if (this.id==1) {
      this.subscription="Free";
    } else if(this.id==2) {
      this.subscription="3 Months Subscription";
    } else if(this.id==3) {
      this.subscription="6 Months Subscription";
    } else if(this.id==4) {
      this.subscription="12 Months Subscription";
    }
    console.log(this.id);
  }

  makePayment(){
    this.response =confirm("payment done");
    console.log(this.response);
    if (this.response) {
      this.service.updateSubscription(this.sessionValueEmail,this.subscription).subscribe(
        data=>{
          this.message=data;
          console.log(this.message);
        },
        error=>{

        }
      )
    } else {
      
    }
  }

}
