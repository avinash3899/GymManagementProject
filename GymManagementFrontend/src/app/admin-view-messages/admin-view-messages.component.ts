import { Component, OnInit } from '@angular/core';
import { Contact } from '../contact';
import { GymserviceService } from '../gymservice.service';

@Component({
  selector: 'app-admin-view-messages',
  templateUrl: './admin-view-messages.component.html',
  styleUrls: ['./admin-view-messages.component.css']
})
export class AdminViewMessagesComponent implements OnInit {

  contact! : Contact[];
  message! : string;
  constructor(private service: GymserviceService) { }

  ngOnInit(): void {
    this.getAllMessages();
  }

  getAllMessages(){
    this.service.getAllMessage().subscribe(
      data =>{
        this.contact=data;
      }, error => { 
        console.error();
      }  
    );

  }

  deleteOneMessage(id: number)
  {
    if(confirm('do you want to delete ?'))
    {
      this.service.deleteOneMessage(id)
      .subscribe(
        data => {
          this.message=data;
          this.getAllMessages();
        }, error =>{ 
          console.error();
        }
      );
    }else{
      this.message='';
    }
  }

}
