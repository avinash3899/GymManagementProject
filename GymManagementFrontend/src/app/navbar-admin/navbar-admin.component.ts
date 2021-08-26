import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-admin',
  templateUrl: './navbar-admin.component.html',
  styleUrls: ['./navbar-admin.component.css']
})
export class NavbarAdminComponent implements OnInit {
  SessionValue: any;
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.SessionValue = sessionStorage.getItem("name");
    if (this.SessionValue == null) {
      this.router.navigate(['gym/login']);
    }
    else if(this.SessionValue != null && sessionStorage.getItem("isAdmin")=="no"){
      this.router.navigate(['gym/user']);
    }
  }

  logout(){
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("name");
    sessionStorage.removeItem("isAdmin");
    this.router.navigate(['gym/login']);
  }

}
