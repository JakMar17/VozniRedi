import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ApiService } from '@data/backend/api.service';
import { ErrorWrapper } from '@data/backend/models/error-wrapper';
import { Postajalisce } from '@data/backend/models/postajalisce';
import { TimetableService } from 'src/app/services/timetable.service';

@Component({
  selector: 'app-search-box',
  templateUrl: './search-box.component.html',
  styleUrls: ['./search-box.component.scss'],
})
export class SearchBoxComponent implements OnInit {
  @Input() public postajalisca: Postajalisce[] | null = null;

  public vstopInput: string = '';
  public izstopInput: string = '';
  public datumInput = new Date();

  public error: string[] | null = null;

  constructor(
    private apiService: ApiService,
    private datePipe: DatePipe,
    timetableServices: TimetableService
  ) {
    timetableServices.searchErrorObservable.subscribe(
      (er) => (this.error = er.errors)
    );
  }

  ngOnInit(): void {}

  public searchTimetable(): void {
    this.error = null;
    const from = this.getPostajalisceObjectFrominput(this.vstopInput);
    const to = this.getPostajalisceObjectFrominput(this.izstopInput);
    const date = this.datePipe.transform(this.datumInput, 'dd.MM.yyyy');

    if (from == null) this.error = ['Vstopna postaja mora biti izbrana'];
    else if (to == null) this.error = ['Izstopna postaja mora biti izbrana'];
    else if (date == null) {
    } else {
      this.apiService.getTimetable(from.id, to.id, date);
    }
  }

  private getPostajalisceObjectFrominput(input: string): Postajalisce | null {
    if (this.postajalisca == null) return null;
    for (const postajalisce of this.postajalisca)
      if (postajalisce.name === input) return postajalisce;

    return null;
  }
}
