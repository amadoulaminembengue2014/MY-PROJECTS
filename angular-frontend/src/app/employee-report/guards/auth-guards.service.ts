import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardsService implements CanActivate {
  user = {
    role: 'ADMIN'
  }
  canActivate(
    next: ActivatedRouteSnapshot,
     state: RouterStateSnapshot): Observable<boolean> |  Promise<boolean> | boolean {
        if(next.data[0] == this.user.role){
          return true;
        }
      // If somebody is logged in return true (accept), otherwise false (reject).
        else{
          return false;
        }
  }

  constructor() { }
}
