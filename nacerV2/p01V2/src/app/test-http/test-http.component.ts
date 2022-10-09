import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Datamodel } from '../models/datamodel';
import { HttpDataService } from '../services/http-data.service';

@Component({
  selector: 'app-test-http',
  templateUrl: './test-http.component.html',
  styleUrls: ['./test-http.component.css']
})
export class TestHttpComponent {

  constructor(private http:HttpClient) { }

  URL:string='http://localhost:8080/treading?from=2020-04-03&to=2020-04-26';

  httpData:any;

  getDatas(){
    this.httpData = this.http.get<Datamodel[]>(this.URL);
     
  }
}
