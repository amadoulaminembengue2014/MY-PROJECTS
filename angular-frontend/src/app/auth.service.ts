import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  auth = 1
  isLoggedIn(): boolean{
    if(this.auth == 1){
    return true;
  }
    else{
      return false;
    }
 }

}
