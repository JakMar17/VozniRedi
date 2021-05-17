export interface Timetable {
  startStop: string;
  endStop: string;
  date?: Date;
  startTime?: string;
  endTime?: string;
  duration?: string;
  noOfStops: number;
  stations: Station[];
}

export interface Station {
  startStation: string;
  endStation: string;
  startTime?: Date;
  endTime?: Date;
  rideTime?: number;
  waitTime?: number;
  stops: Stop[];
}

export interface Stop {
  inSequence: number;
  station: string;
  arrivingTime?: Date;
  departureTime?: Date;
}
