import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AuthService } from './auth.service';
import { CreateEmployeeReportComponent } from './create-employee-report/create-employee-report.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeReportComponent } from './employee-report/employee-report.component';
import { AuthGuardsService } from './employee-report/guards/auth-guards.service';
import { CheckGuard } from './guards/check.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReportsComponent } from './reports/reports.component';
import { SignupComponent } from './signup/signup.component';
import { TimesheetComponent } from './timesheet/timesheet.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { UpdateReportComponent } from './update-report/update-report.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AuthGuard } from "./auth.guard";
import { LoginRolesComponent } from './login-roles/login-roles.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { DocumentionComponent } from './documention/documention.component';
import { DocumentionsComponent } from './documentions/documentions.component';
import { DocumentComponent } from './document/document.component';
import { SeeMoreComponent } from './see-more/see-more.component';





const routes: Routes = [

  { path: '', redirectTo: 'homes', pathMatch: 'full' },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '', redirectTo: 'login-role', pathMatch: 'full' },
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: '', redirectTo: 'reports', pathMatch: 'full' },
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  { path: 'employees',
   component: EmployeeListComponent,
   canActivate: [AuthGuard]
   /*canActivateChild: [AuthGuardsService],
   data:['ADMIN'],
   children: [
    
  ]*/
},

{ path: 'create-employee',component: CreateEmployeeComponent, canActivate: [AuthGuard]},
{ path: 'create-employee-report',component: CreateEmployeeReportComponent},

  { path: 'update-employee/:id', component: UpdateEmployeeComponent },
  { path: 'update-report/:id', component: UpdateReportComponent },
  { path: 'employee-details/:id', component: EmployeeDetailsComponent },
  { path: 'employee-report/:id', component: EmployeeReportComponent },
  { path: 'reports', component: ReportsComponent, canDeactivate: [CheckGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent, canDeactivate: [CheckGuard]},
  { path: 'about', component: AboutComponent },
  { path: 'timesheet', component: TimesheetComponent},
  { path: 'home', component: HomeComponent},
  { path: 'home-user', component: HomeUserComponent},
  { path: 'login-role', component: LoginRolesComponent},
  { path: 'welcome', component: WelcomeComponent},
  { path: 'documentation', component: DocumentionComponent},
  { path: 'documentations', component: DocumentionsComponent},
  { path: 'document', component: DocumentComponent},
  { path: 'see-more', component: SeeMoreComponent},


];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthService]
})
export class AppRoutingModule { }
