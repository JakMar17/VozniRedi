import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimetableLayoutComponent } from './timetable-layout.component';

describe('TimetableLayoutComponent', () => {
  let component: TimetableLayoutComponent;
  let fixture: ComponentFixture<TimetableLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimetableLayoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimetableLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
