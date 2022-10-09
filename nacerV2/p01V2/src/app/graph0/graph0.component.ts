import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Chart , registerables  } from 'node_modules/chart.js';
import { Datamodel } from '../models/datamodel';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-graph0',
  templateUrl: './graph0.component.html',
  styleUrls: ['./graph0.component.css']
})
export class Graph0Component implements OnInit {

  httpData0:any;
  
  link : string;

  dates : string[]=[];

  values : string[]=[]; 
  

  constructor(private data1 : DataServiceService , private http:HttpClient) {
    Chart.register(...registerables);
   }

  async ngOnInit() {

    this.link = 'http://localhost:8080/treading?from=2020-04-03&to=2020-04-14';
    
    this.httpData0 =await  this.http.get<Datamodel[]>(this.link).toPromise();

    var i=0;
    this.httpData0.forEach(element => {
      //console.log('hhhhhhhh'+element.date);
      this.dates.push(element.date);
      this.values.push(String(Number(element.value)*10));
      console.log(this.dates[i]);
      console.log(this.values[i]);
      i++;

    });

    //for await (const d of this.httpData0) {
      //var i=0;
      //this.dates.push(d.date);
     // console.log(d.date);
      //console.log(d.value);
      //i++;
    //}

    const myChart = new Chart("myChart", {
      type: 'radar',
      data: {
          labels: this.dates,
          datasets:  [{
            label: '# of Votes',
            data: this.values,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
      },
      options: {
          scales: {
              y: {
                  beginAtZero: true
              }
          }
      }
  });
      
  }

  

}
