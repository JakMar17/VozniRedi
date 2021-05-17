import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@env';
import { Observable } from 'rxjs';
import { TimetableService } from 'src/app/services/timetable.service';
import { ErrorWrapper } from './models/error-wrapper';
import { Postajalisce } from './models/postajalisce';
import { Timetable } from './models/timetable';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl: string = environment.BASE_URL;

  constructor(
    private http: HttpClient,
    private timetablesServices: TimetableService
  ) {}

  public getAllPostajalisca(): void {
    this.http.get<Postajalisce[]>(this.baseUrl + 'stations/all').subscribe(
      (data) => {
        console.log(data);
        this.timetablesServices.postajalisca.next(data);
        this.timetablesServices.searchView.next('show');
      },
      (err: HttpErrorResponse) => {
        const wrapper: ErrorWrapper = err.error;
        this.timetablesServices.searchErrorObservable.next(wrapper);
      }
    );
  }

  public getTimetable(from: number, to: number, date: string): void {
    this.timetablesServices.timetableView.next('loading');
    this.http
      .get<Timetable[]>(
        this.baseUrl + '/timetable?from=' + from + '&to=' + to + '&date=' + date
      )
      .subscribe(
        (data) => {
          this.timetablesServices.timetables.next(data);
          this.timetablesServices.timetableView.next('show');
        },
        (err: HttpErrorResponse) => {
          const wrapper: ErrorWrapper = err.error;
          this.timetablesServices.timetableErrorObservable.next(wrapper);
        }
      );
  }
}
