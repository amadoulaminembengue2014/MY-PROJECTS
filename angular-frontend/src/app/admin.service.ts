import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseURL = "http://localhost:8080/api/admins";


  constructor(private httpClient: HttpClient) { }

  getAdminsList(): Observable<AdminService[]>{
    return this.httpClient.get<AdminService[]>(`${this.baseURL}`);
  }

  createAdmin(admin: AdminService): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, admin);
  }

  
}
