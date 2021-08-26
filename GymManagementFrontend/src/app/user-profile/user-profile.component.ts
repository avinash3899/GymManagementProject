import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { GymserviceService } from '../gymservice.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  customerProfile!: Customer;
  cpassword!:string;
  sessionValue: any;
  constructor(private service: GymserviceService) { }

  ngOnInit(): void {
    this.sessionValue = sessionStorage.getItem("email");
    this.customerProfile=new Customer();
    this.fetchCustomerProfile(this.sessionValue);
    
  }

  fetchCustomerProfile(email:string) {
    this.service.getCustomerByEmail(email).subscribe(
      data=>{
        this.customerProfile=data;
        this.customerProfile.password="";
        console.log(data);
      },
      error=>{
        console.log(error);
      }
    )
  }

  changePassword(){
    this.service.resetPassword(this.customerProfile).subscribe(
      data=>{
        alert(data);
        this.customerProfile.password="";
        this.cpassword="";
      },
      error=>{
        alert(error);
      }
    )
  }

}
