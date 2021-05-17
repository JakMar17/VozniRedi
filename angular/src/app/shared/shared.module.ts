import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { LoadingComponent } from '@layouts/loading/loading.component';

@NgModule({
  declarations: [
    LoadingComponent
  ],
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  exports: [CommonModule, FormsModule, ReactiveFormsModule, LoadingComponent],
})
export class SharedModule {}
