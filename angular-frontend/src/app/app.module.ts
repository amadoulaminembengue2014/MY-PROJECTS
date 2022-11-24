import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { RouterModule } from '@angular/router';
import { ReportsComponent } from './reports/reports.component';
import { EmployeeReportComponent } from './employee-report/employee-report.component';
import { CreateEmployeeReportComponent } from './create-employee-report/create-employee-report.component';
import { UpdateReportComponent } from './update-report/update-report.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AboutComponent } from './about/about.component';
import { ScheduleModule, RecurrenceEditorModule, DayService, WeekService, WorkWeekService, MonthService, AgendaService, TimelineViewsService, TimelineMonthService, DragAndDropService, ResizeService } from '@syncfusion/ej2-angular-schedule';
import { TimesheetComponent } from './timesheet/timesheet.component';
import { TreeViewModule } from '@syncfusion/ej2-angular-navigations';
import { CalendarModule } from '@syncfusion/ej2-angular-calendars';
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AuthGuardsService } from './employee-report/guards/auth-guards.service';
import { CheckGuard } from './guards/check.guard';
import { HomesComponent } from './homes/homes.component';
import { LoginsComponent } from './logins/logins.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ViewInformationComponent } from './view-information/view-information.component';
import { LoginRolesComponent } from './login-roles/login-roles.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { DocumentionComponent } from './documention/documention.component';
import { DocumentionsComponent } from './documentions/documentions.component';
import { DocumentComponent } from './document/document.component';
import { SeeMoreComponent } from './see-more/see-more.component';







@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    EmployeeDetailsComponent,
    LoginComponent,
    SignupComponent,
    ReportsComponent,
    EmployeeReportComponent,
    CreateEmployeeReportComponent,
    UpdateReportComponent,
    AboutComponent,
    TimesheetComponent,
    HomeComponent,
    WelcomeComponent,
    HomesComponent,
    LoginsComponent,
    AdminComponent,
    UserComponent,
    ViewInformationComponent,
    LoginRolesComponent,
    HomeUserComponent,
    DocumentionComponent,
    DocumentionsComponent,
    DocumentComponent,
    SeeMoreComponent,
    
   
   
    
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    Ng2SearchPipeModule,
    ScheduleModule, RecurrenceEditorModule, TreeViewModule,
    CalendarModule,
    
    
    
    
    
    
    
    RouterModule.forRoot([  
      {  
        path : 'homes',  
        component : HomesComponent   
      },  
      {  
        path : 'logins',  
        component : LoginsComponent    
      },  
      {  
        path : 'admin',  
        component : AdminComponent    
      }, 
      {  
        path : 'user',  
        component : UserComponent    
      },  
      {  
        path : 'view-information/:id',  
        component : ViewInformationComponent    
      },  
      
    ])  
    
  
    
  ],
  providers: [AuthGuardsService,CheckGuard,    DayService, WeekService, WorkWeekService, MonthService,
   AgendaService, TimelineViewsService, TimelineMonthService, DragAndDropService, ResizeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
