import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(inputArray: any,propertyName: string,choice:string): any {
    if(choice==='')
      return inputArray;
    let outputArray=[]
    inputArray.forEach(obj => {
      if(obj[propertyName].toLowerCase()==choice.toLowerCase())
        outputArray.push(obj)
    });

    return outputArray;
  }

}
