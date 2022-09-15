import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';

@Component({
  selector: 'app-custom-pipes',
  templateUrl: './custom-pipes.component.html',
  styleUrls: ['./custom-pipes.component.css']
})
export class CustomPipesComponent implements OnInit {
  username='Priya'
  choice=''
  joinDate:Date=new Date();
   employee = {
      name:'Rohan',
      salary:9000,
      birthday:'1990-02-18T16:30:00',
      bonus:2000.2345,
}

courses:Course[]=[
  new Course(1,'Java',4000,'Backend'),
  new Course(2,'Angular',14000,'Web'),
  new Course(4,'Spring',8000,'Backend'),
  new Course(3,'Node',6000,'Web'),
  new Course(5,'DBMS',5000,'Backend'),
  new Course(6,'HTML',1000,'Web'),
  new Course(7,'CSS',1000,'Frontend'),
  new Course(8,'JS',2000,'Frontend')

]




  constructor() { }

  ngOnInit(): void {
  }

}
