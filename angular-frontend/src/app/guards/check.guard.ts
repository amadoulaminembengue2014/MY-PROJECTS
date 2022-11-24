import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { ReportsComponent } from '../reports/reports.component';

@Injectable({
  providedIn: 'root'
})
export class CheckGuard implements CanDeactivate<ReportsComponent> {
  canDeactivate(
    reports: ReportsComponent,
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(reports.name != ""){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Succesfull, you are create a new Employee !',
          showConfirmButton: false,
          timer: 8000
        })
        
      }
      

    return true;
  }
  
}
