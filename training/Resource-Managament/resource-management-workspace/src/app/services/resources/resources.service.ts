import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Resource } from 'projects/resource-manager/src/lib/models/resources/resource';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ResourcesService {

  private BASEURL: string = '/api';

  constructor(private httpClient: HttpClient) {}

  getAllResources = (): Observable<Resource[]> => {
    const url = this.BASEURL + '/resource';
    return this.httpClient.get<Resource[]>(url)
  }
}
