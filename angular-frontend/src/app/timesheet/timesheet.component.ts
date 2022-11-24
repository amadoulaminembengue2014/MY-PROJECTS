import { Component, OnInit } from '@angular/core';
import { DragEventArgs, EventSettingsModel, ResizeEventArgs, View, } from '@syncfusion/ej2-angular-schedule';


@Component({
  selector: 'app-timesheet',
  template: '<ejs-schedule style="background-color: #565a97;" height="850" width="1250"  [eventSettings]="eventObject" [selectedDate]="setDate"  [currentView]="setView" dragStart="onDragStart($event)" resizeStart="onResizeStart($event)"></ejs-schedule>',
  
 // templateUrl: './timesheet.component.html',
  styleUrls: ['./timesheet.component.css']
})
export class TimesheetComponent implements OnInit {

  public setView : View = 'Week';
  public setDate : Date = new Date(2022, 10,19);
  public eventObject: EventSettingsModel = {
    dataSource:[{
      id: 1,
      Subject: 'Meditation time',
      StartTime: new Date(2022, 10, 19, 11, 0),
      EndTime: new Date(2022, 10, 19, 12, 0)
  },
  {
    id: 2,
      Subject: 'Lamine',
      StartTime: new Date(2022, 10, 19, 9, 0),
      EndTime: new Date(2022, 10, 18, 12, 0)
  }
]
}

onDragStart(args: DragEventArgs): void {
  args.scroll!.enable = false;
  args.scroll!.scrollBy = 500;
  args.interval = 1;
  args.navigation!.enable = true;
  
}
onResizeStart(args: ResizeEventArgs): void {
  args.scroll!.enable = false;
  args.scroll!.scrollBy = 500;
  args.interval = 1;
}


  constructor() { }

  ngOnInit(): void {
  }

}









/*private eventData: DataManager = new DataManager({
    url:'https://js.syncfusion.com/demos/ejservices/api/Schedule/LoadData',
    adaptor: new WebApiAdaptor,
    crossDomain: true
  });*/


//IsBlock: true
      //IsReadonly: true
      //RecurrenceRule: "FREQ=DAILY; INTERVAL=1; COUNT=10"
      //IsAllDay: true