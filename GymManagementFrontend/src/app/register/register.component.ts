import { Component, OnInit } from '@angular/core';
import { GymserviceService } from '../gymservice.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  customer!: Customer;
  message!: string;
  confirmPassword!: string;

  constructor(private service:GymserviceService,private router:Router) { }

  ngOnInit(): void {
    this.customer = new Customer();
  }

  
  createCustomer(){
    if (this.customer.password!=this.confirmPassword) {
      alert("Password Mismatch");
      return;
    }
    this.service.createCustomer(this.customer).subscribe(
      data=>{
        this.message=data;
        console.log(data);
        alert("Successfully Registered");
        this.router.navigate(['gym/login']);
      },
      error=>{
        console.log(error);
        console.log(this.customer);
        alert(error);
        this.customer=new Customer;
      }
    );
  }
}
