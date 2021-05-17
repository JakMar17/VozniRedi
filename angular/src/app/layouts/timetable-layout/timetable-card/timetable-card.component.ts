import { Component, OnInit } from '@angular/core';
import { Timetable } from '@data/backend/models/timetable';
import { TimetableService } from 'src/app/services/timetable.service';

@Component({
  selector: 'app-timetable-card',
  templateUrl: './timetable-card.component.html',
  styleUrls: ['./timetable-card.component.scss']
})
export class TimetableCardComponent implements OnInit {

  public timetables: Timetable[] | null = null;

  constructor(private timetablesServices: TimetableService) {
    timetablesServices.timetables.subscribe(data => this.timetables = data);
  }

  ngOnInit(): void {
  }

}
