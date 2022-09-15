import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contract } from '../model/contract';
import { ContractService } from '../services/contract.service';

@Component({
  selector: 'app-contract-details',
  templateUrl: './contract-details.component.html',
  styleUrls: ['./contract-details.component.css']
})
export class ContractDetailsComponent implements OnInit {

  contractId: number;
  contract: Contract;
  constructor(
    private _contractService: ContractService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (map) => (this.contractId = parseInt(map.get('id')))
    );

    this._contractService.getById(this.contractId).subscribe((response) => {
      this.contract = response;
      console.log(this.contract);
    });
}
}
