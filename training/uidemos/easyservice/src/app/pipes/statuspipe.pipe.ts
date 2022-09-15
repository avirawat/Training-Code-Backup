import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'statuspipe'
})
export class StatuspipePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
