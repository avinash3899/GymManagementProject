import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { GymserviceService } from '../gymservice.service';

@Component({
  selector: 'app-admin-view-users',
  templateUrl: './admin-view-users.component.html',
  styleUrls: ['./admin-view-users.component.css']
})
export class AdminViewUsersComponent implements OnInit {

  customer! : Customer[];
  message! : string;
  constructor(private service: GymserviceService) { }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  getAllCustomer(){
    this.service.getAllCustomer().subscribe(
      data =>{
        this.customer=data;
      }, error => { 
        console.error();
      }  
    );

  }

  deleteOneCustomer(id: number,email:string)
  {
    if(email==sessionStorage.getItem("email")){
      alert("Could not delete currntly loged in user.");
      return;
    }
    if(confirm('do you want to delete ?'))
    {
      this.service.deleteOneCustomer(id)
      .subscribe(
        data => {
          this.message=data;
          this.getAllCustomer();
        }, error =>{ 
          console.error();
        }
      );
    }else{
      this.message='';
    }
  }

}
