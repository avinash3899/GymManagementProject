import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Contact } from './contact';
@Injectable({
  providedIn: 'root'
})
export class GymserviceService {
  private basePath = 'http://localhost:12345/gym';
  
  constructor(private http: HttpClient) { }


  public createCustomer(customer:Customer):Observable<any>{
    return this.http.post(`${this.basePath}/createCustomer`, customer, {responseType: 'text'});
  }


  public sendMessage(message:Contact):Observable<any>{
    return this.http.post(`${this.basePath}/sendMessage`, message, {responseType: 'text'});
  }


  public loginvalidate(email:string,password:string):Observable<any>{
    return this.http.get<any>(`${this.basePath}/loginvalidate/${email}/${password}`);
  }


  public updateSubscription(email:string, subscription:string): Observable<any> {
    return this.http.put(`${this.basePath}/updateSubscription/${email}`, subscription, {responseType : 'text'});
  }


  public resetPassword(customer:Customer):Observable<any>{
    return this.http.post(`${this.basePath}/resetPassword`,customer, {responseType : 'text'});
  }
  

  public getAllCustomer(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.basePath}/allcustomer` );
    
  }


  public deleteOneCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.basePath}/remove/${id}`, {responseType: 'text'});
  }
  
  
  public getCustomerByEmail(email:string):Observable<Customer>{
    return this.http.get<Customer>(`${this.basePath}/getUserProfile/${email}`);
  }

  public getAllMessage(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.basePath}/allmessages` );
  }


  public deleteOneMessage(id: number): Observable<any> {
    return this.http.delete(`${this.basePath}/removeMessage/${id}`, {responseType: 'text'});
  }

  public sendOTP(email:string,otp:string):Observable<any>{
    return this.http.get(`https://maker.ifttt.com/trigger/otpservice/with/key/bc7uopg2Kew0xxhrCuLiue?value1=${email}&value2=${otp}`,{responseType : 'text'});
  }

}
