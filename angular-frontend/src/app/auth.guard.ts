import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthService){

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    //return true;

    if(this.auth.isLoggedIn()){
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Great, now You can to Manage',
        showConfirmButton: true,
        
      })

      return true;
    
  }
  else{
Swal.fire('You are not authorized to into this area');

return false;
  }
  
}
}
