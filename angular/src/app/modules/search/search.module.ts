import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { SearchRoutingModule } from './search-routing.module';
import { SharedModule } from '@shared/shared.module';
import { TimetableCardComponent } from '../../layouts/timetable-layout/timetable-card/timetable-card.component';
import { TransfersPipe } from '@layouts/timetable-layout/timetable-card/transfers.pipe';
import { NoOfStopsPipe } from '../../layouts/timetable-layout/timetable-card/no-of-stops.pipe';
import { TimetableLayoutComponent } from '../../layouts/timetable-layout/timetable-layout.component';
import { SearchBoxComponent } from '../../layouts/timetable-layout/search-box/search-box.component';

@NgModule({
  declarations: [
    TimetableCardComponent,
    TransfersPipe,
    NoOfStopsPipe,
    TimetableLayoutComponent,
    SearchBoxComponent,
  ],
  imports: [CommonModule, SearchRoutingModule, SharedModule],
  providers: [DatePipe],
})
export class SearchModule {}
