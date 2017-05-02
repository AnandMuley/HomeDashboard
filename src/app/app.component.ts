import { Component } from '@angular/core';
import {DashboardItem} from './dashboard-item/dashboard-item.component'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Home Dashboard';
  items:DashboardItem[];

  constructor(){
    this.items = [{
      title:"Investments",
      image:"assets/images/investment.jpg",
      content: `Manage and track my investments to get better idea about the ROI`
    },{
      title:"Servicing",
      image:"assets/images/car-servicing.jpg",
      content: `
        The car and bike servicing details are collated here
      `
    }]
  }

}
