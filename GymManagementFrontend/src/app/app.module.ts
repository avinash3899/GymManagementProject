import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';
import { NavbarAdminComponent } from './navbar-admin/navbar-admin.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { TrainersComponent } from './trainers/trainers.component';
import { PricingComponent } from './pricing/pricing.component';
import { PaymentComponent } from './payment/payment.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminViewUsersComponent } from './admin-view-users/admin-view-users.component';
import { AdminViewMessagesComponent } from './admin-view-messages/admin-view-messages.component';
import { RegisterComponent } from './register/register.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';


import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


const routes: Routes = [
  { path: '', redirectTo: '/gym/home', pathMatch: 'full' },
  {
    path: 'gym', component: NavbarComponent,
    children:
      [
        { path: '', redirectTo: 'home', pathMatch: 'full' },
        { path: 'home', component: HomeComponent },
        { path: 'about', component: AboutComponent },
        { path: 'trainers', component: TrainersComponent },
        { path: 'pricing', component: PricingComponent },
        { path: 'payment/:id', component: PaymentComponent },
        { path: 'contact', component: ContactComponent },
        { path: 'register', component: RegisterComponent },
        { path: 'login', component: LoginComponent },
        { path: 'forgotpassword', component:ForgotpasswordComponent}
      ]
  }
  ,
  {
    path: 'gym/user', component: NavbarUserComponent,
    children:
      [
        { path: '', redirectTo: 'home', pathMatch: 'full' },
        { path: 'home', component: HomeComponent },
        { path: 'about', component: AboutComponent },
        { path: 'trainers', component: TrainersComponent },
        { path: 'pricing', component: PricingComponent },
        { path: 'payment/:id', component: PaymentComponent },
        { path: 'contact', component: ContactComponent },
        { path: 'userProfile', component: UserProfileComponent },
        { path: 'userDashboard', component: UserDashboardComponent }
        
      ]
  }
  ,
  {
    path: 'gym/admin', component: NavbarAdminComponent,
    children:
      [
        { path: '', redirectTo: 'home', pathMatch: 'full' },
        { path: 'home', component: HomeComponent },
        { path: 'about', component: AboutComponent },
        { path: 'trainers', component: TrainersComponent },
        { path: 'pricing', component: PricingComponent },
        { path: 'payment/:id', component: PaymentComponent },
        { path: 'contact', component: ContactComponent },
        { path: 'userProfile', component: UserProfileComponent },
        { path: 'userDashboard', component: UserDashboardComponent },
        { path: 'adminViewUsers', component: AdminViewUsersComponent },
        { path: 'adminViewMessages', component: AdminViewMessagesComponent }

      ]
  }

]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NavbarUserComponent,
    NavbarAdminComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    TrainersComponent,
    PricingComponent,
    PaymentComponent,
    ContactComponent,
    LoginComponent,
    UserProfileComponent,
    UserDashboardComponent,
    AdminViewUsersComponent,
    AdminViewMessagesComponent,
    RegisterComponent,
    ForgotpasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
