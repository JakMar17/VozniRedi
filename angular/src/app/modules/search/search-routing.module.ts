import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TimetableLayoutComponent } from '@layouts/timetable-layout/timetable-layout.component';

const routes: Routes = [
  {
    path: '',
    component: TimetableLayoutComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SearchRoutingModule {}
