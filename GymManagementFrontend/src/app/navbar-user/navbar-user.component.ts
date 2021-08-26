import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-user',
  templateUrl: './navbar-user.component.html',
  styleUrls: ['./navbar-user.component.css']
})
export class NavbarUserComponent implements OnInit {
  SessionValue:any;

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.SessionValue = sessionStorage.getItem("name");
    if(this.SessionValue == null ){
      this.router.navigate(['gym/login']);
    }
    else if(this.SessionValue != null && sessionStorage.getItem("isAdmin")=="yes"){
      this.router.navigate(['gym/admin']);
    }
  }

  logout(){
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("name");
    sessionStorage.removeItem("isAdmin");
    this.router.navigate(['gym/login']);
  }

}
