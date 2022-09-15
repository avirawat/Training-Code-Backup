import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'time'
})
export class TimePipe implements PipeTransform {

  transform(date: Date,type?:string): any {
    if(type=='t')
    return date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    if(type=='d')
     // return date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear();
     return date;
  }

}
