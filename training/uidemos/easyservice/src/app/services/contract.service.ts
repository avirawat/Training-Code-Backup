import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contract } from '../model/contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  private _baseurl="http://localhost:8070/contractor-service"

  constructor(private _http:HttpClient) { }

  getAllContracts():Observable<Contract[]>{
    let url=this._baseurl+"/contracts"
    return this._http.get<Contract[]>(url);
  }

  getById(contractId:number):Observable<Contract>{
    let url=this._baseurl+"/contracts/contractId/"+contractId;
    return this._http.get<Contract>(url);
  }

}
