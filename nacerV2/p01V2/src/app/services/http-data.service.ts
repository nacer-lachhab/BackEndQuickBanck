import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Datamodel } from '../models/datamodel';


@Injectable({
  providedIn: 'root'
})
export class HttpDataService {

  constructor(private http:HttpClient) { };

  URL:string='http://localhost:8080/treading?from=2020-04-03&to=2020-04-26';

  httpData:any;

  getDatas(){
    let x= this.http.get<Datamodel[]>(this.URL);
     return x;
  }

  
}
