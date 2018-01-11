import { Injectable } from '@angular/core';

@Injectable()
export class WebserviceService {

  private webServiceRootUrl = "http://localhost:8082/api/";
  constructor() { }

  getRootUrl () : string
  {
    return this.webServiceRootUrl;
  }

}
