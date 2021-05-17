import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AboutRoutingModule } from './about-routing.module';
import { AboutLayoutComponent } from '../../layouts/about-layout/about-layout.component';


@NgModule({
  declarations: [
    AboutLayoutComponent
  ],
  imports: [
    CommonModule,
    AboutRoutingModule
  ]
})
export class AboutModule { }
