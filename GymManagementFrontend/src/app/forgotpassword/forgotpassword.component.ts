import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { GymserviceService } from '../gymservice.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {
  customer!: Customer;
  response!: string;
  otp!: string;
  typedOTP!: string;
  constructor(private service: GymserviceService, private router: Router) { }

  ngOnInit(): void {
    this.customer = new Customer();
  }

  resetPassword() {
    if (this.otp != null && (this.typedOTP == this.otp)) {
      this.service.resetPassword(this.customer).subscribe(
        data => {
          this.response = data;
          alert(data);
        },
        error => {
          console.log(error);
        }
      );
      this.router.navigate(['gym/login']);
    }
    else {
      alert("wrong otp");
    }
  }

  sendOTP() {
    this.service.getCustomerByEmail(this.customer.email).subscribe(
      data => {
        if (data != null) {
          console.log(data);
          this.otp = this.makeid(5);
          this.service.sendOTP(this.customer.email, this.otp).subscribe(
            data => {
              console.log(data);
            },
            error => {
              console.log(error);
            }
          );
          alert("otp sent");
        }
        else {
          console.log(data);
          alert("User not found");
        }
      },
      error => {
        console.log(error);

      }
    )

  }

  verifyOTP() {

  }

  makeid(length: number) {
    var result = '';
    var characters = '0123456789';
    var charactersLength = characters.length;
    for (var i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() *
        charactersLength));
    }
    return result;
  }
}
