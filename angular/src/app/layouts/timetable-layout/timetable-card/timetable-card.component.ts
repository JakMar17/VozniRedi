import { Component, Input, OnInit } from '@angular/core';
import { Timetable } from '@data/backend/models/timetable';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { TimetableService } from 'src/app/services/timetable.service';

@Component({
  selector: 'app-timetable-card',
  templateUrl: './timetable-card.component.html',
  styleUrls: ['./timetable-card.component.scss'],
})
export class TimetableCardComponent implements OnInit {
  @Input() public timetable: Timetable | any;

  closeResult = '';

  constructor(private modalService: NgbModal) {}

  ngOnInit(): void {}

  open(content: any) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title', size: 'xl' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
