import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  getData():any{
    return {
      labels: ['0.1', '0.2', '0.3', '0.4', '0.5', '0.6',2],
      datasets: [{
          label: '# Dollar Values',
          data: [20, 19, 3, 5, 2, 3,30],
          backgroundColor:"#FF00FF",
          /* [
              'rgba(255, 99, 0, 0.2)',
              'rgba(54, 162, 2, 0.2)',
              'rgba(255, 206, 3, 0.2)',
              'rgba(75, 192, 4, 0.2)',
              'rgba(153, 102, 5, 0.2)',
              'rgba(255, 159, 6, 0.2)',
              'rgba(255, 159, 7, 0.2)'
          ],*/
          borderColor: '#0000FF',/*[
              'rgba(255, 99, 0, 1)',
              'rgba(54, 162, 2, 1)',
              'rgba(255, 206, 3, 1)',
              'rgba(75, 192, 4, 1)',
              'rgba(153, 102, 5, 1)',
              'rgba(255, 159, 6, 1)',
              'rgba(255, 159, 7, 1)'
          ],*/
          borderWidth: 1
      }]
  }
  }
}
