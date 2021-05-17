import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutLayoutComponent } from '@layouts/about-layout/about-layout.component';

const routes: Routes = [
  {
    path: '',
    component: AboutLayoutComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AboutRoutingModule { }
