import { Component, OnInit } from '@angular/core';
import { GymserviceService, } from '../gymservice.service';
import { Contact } from '../contact';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  message!: string;
  contact!: Contact;
  name!: any;
  email!: any;
  constructor(private service: GymserviceService) { }

  ngOnInit(): void {
    this.contact = new Contact();
    if (sessionStorage.getItem("email") != null) {
      this.name = sessionStorage.getItem("name");
      this.email = sessionStorage.getItem("email");
      this.contact.name = this.name;
      this.contact.email = this.email;
      this.contact.messageType = "Subject";
      this.contact.message = "Message:";

    } else {
      this.contact.name = "Name";
      this.contact.email = "Email";
      this.contact.messageType = "Subject";
      this.contact.message = "Message:";
    }
  }

  sendMessage() {
    this.service.sendMessage(this.contact).subscribe(
      data => {
        this.message = data;
        if (this.message != null) {
          alert("Message Sent");
        }
        this.name = sessionStorage.getItem("name");
        this.email = sessionStorage.getItem("email");
        this.contact.name = this.name;
        this.contact.email = this.email;
        this.contact.messageType = "Subject";
        this.contact.message = "Message:";
      },
      error => {
        console.log(error);
        alert("Message not sent");
        this.name = sessionStorage.getItem("name");
        this.email = sessionStorage.getItem("email");
        this.contact.name = this.name;
        this.contact.email = this.email;
        this.contact.messageType = "Subject";
        this.contact.message = "Message:";
      }
    )
  }

}
