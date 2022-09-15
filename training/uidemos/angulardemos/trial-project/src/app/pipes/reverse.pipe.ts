import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reverse'
})
export class ReversePipe implements PipeTransform {

  transform(uname: string, ...args: unknown[]): string {

    return uname.split('').reverse().join('');
  }

}
