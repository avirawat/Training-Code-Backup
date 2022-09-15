import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Contract } from '../model/contract';
import { ContractService } from '../services/contract.service';

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.css']
})
export class ContractComponent implements OnInit {

  contracts:Contract[]

  searchText='';

  constructor(private contractService:ContractService,private route:Router) { }

  ngOnInit(): void {
    this.contractService.getAllContracts().subscribe(
      (contractsList)=>{
        this.contracts=contractsList;
        console.log(contractsList);
      },
      error =>console.log(error),
      ()=>console.log('completed')
    )
  }

  onSearch =(contract:Contract)=>{
    this.route.navigate(['/contract-details',contract.contractId])
  }
}
