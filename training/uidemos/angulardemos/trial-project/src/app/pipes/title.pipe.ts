import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'title'
})
export class TitlePipe implements PipeTransform {

  transform(uname: string,gender?:string): string {
    if(gender=='male')
      return "Mr. " +uname;
    else if(gender=='female')
      return "Ms "+uname;
    else
      return uname;
  }

}
