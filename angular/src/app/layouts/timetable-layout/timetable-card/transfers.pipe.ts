import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'transfers',
})
export class TransfersPipe implements PipeTransform {
  transform(noOfStops: number): string {
    if (noOfStops == null || noOfStops == 0)
      return 'Brez prestopov / direktna povezava';
    else return 'Število prestopov: ' + noOfStops;
  }
}
