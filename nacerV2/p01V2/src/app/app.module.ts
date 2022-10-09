import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { Chart } from 'chart.js';

import { AppComponent } from './app.component';
import { Graph0Component } from './graph0/graph0.component';
import { TestHttpComponent } from './test-http/test-http.component';

@NgModule({
  declarations: [
    AppComponent,
    Graph0Component,
    TestHttpComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
