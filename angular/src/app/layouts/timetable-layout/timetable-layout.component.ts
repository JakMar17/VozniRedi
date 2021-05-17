import { Component, OnInit } from '@angular/core';
import { ApiService } from '@data/backend/api.service';
import { Postajalisce } from '@data/backend/models/postajalisce';
import { Timetable } from '@data/backend/models/timetable';
import { Subject } from 'rxjs';
import {
  ShowComponentState,
  TimetableService,
} from 'src/app/services/timetable.service';

@Component({
  selector: 'app-timetable-layout',
  templateUrl: './timetable-layout.component.html',
  styleUrls: ['./timetable-layout.component.scss'],
})
export class TimetableLayoutComponent implements OnInit {
  public searchboxViewState: ShowComponentState = 'not_show';
  public timetableViewState: ShowComponentState = 'not_show';
  public timetables: Timetable[] | null = null;
  public postajalisca: Postajalisce[] = [];

  constructor(
    private timetableService: TimetableService,
    apiService: ApiService
  ) {
    timetableService.searchView.subscribe(
      (data) => (this.searchboxViewState = data)
    );
    timetableService.timetableView.subscribe(
      (data) => (this.timetableViewState = data)
    );

    timetableService.postajalisca.subscribe(
      (data) => (this.postajalisca = data)
    );

    this.timetableService.timetables.subscribe(
      (data) => (this.timetables = data)
    );

    timetableService.searchView.next('loading');
    apiService.getAllPostajalisca();
  }

  ngOnInit(): void {}
}
