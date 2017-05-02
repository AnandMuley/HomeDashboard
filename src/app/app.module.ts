import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { InvestmentComponent } from './investment/investment.component';
import { DashboardItemComponent } from './dashboard-item/dashboard-item.component';

@NgModule({
  declarations: [
    AppComponent,
    InvestmentComponent,
    DashboardItemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
