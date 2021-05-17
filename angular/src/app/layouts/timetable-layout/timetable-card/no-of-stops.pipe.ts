import { Pipe, PipeTransform } from '@angular/core';
import { Station, Stop } from '@data/backend/models/timetable';

@Pipe({
  name: 'noOfStops'
})
export class NoOfStopsPipe implements PipeTransform {

  transform(stations: Station[]): number {
    let count = 0;
    for(let station of stations) {
      count += (station.stops.length -1);
    }
    return count -2;
  }

}
