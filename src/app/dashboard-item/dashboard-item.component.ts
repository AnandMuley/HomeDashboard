import { Component, OnInit,Input } from '@angular/core';

export class DashboardItem{
  title:string;
  image:string;
  content:string;
}

@Component({
  selector: 'app-dashboard-item',
  templateUrl: './dashboard-item.component.html',
  styleUrls: ['./dashboard-item.component.css']
})
export class DashboardItemComponent implements OnInit {

  @Input() data:DashboardItem;

  constructor() { }

  ngOnInit() {
  }

}
