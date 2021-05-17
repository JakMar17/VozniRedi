import { Injectable } from '@angular/core';
import { Postajalisce } from '@data/backend/models/postajalisce';
import { Timetable } from '@data/backend/models/timetable';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TimetableService {
  public timetables: Subject<Timetable[]> = new Subject();
  public postajalisca: Subject<Postajalisce[]> = new Subject();
  
  public searchView: Subject<ShowComponentState> = new Subject();
  public timetableView: Subject<ShowComponentState> = new Subject();

  constructor() {
    this.timetableView.next('not_show');
    this.searchView.subscribe(data => console.log(data))
    this.searchView.next('not_show');
  }
}

export type ShowComponentState = 'loading' | 'show' | 'not_show';
