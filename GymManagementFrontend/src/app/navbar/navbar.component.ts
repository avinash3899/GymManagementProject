import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  sessionValue:any;
  isAdmin:any;
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.sessionValue=sessionStorage.getItem("name");
    this.isAdmin=sessionStorage.getItem("isAdmin");
    if (this.sessionValue!=null) {
      if(this.isAdmin=="no")
      this.router.navigate(['gym/user']);
      else if(this.isAdmin=="yes")
      this.router.navigate(['gym/admin']);
    }
  }

}
