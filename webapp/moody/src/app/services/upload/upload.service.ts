import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  private uploadUrl = '';
  private downloadUrl = '';
  constructor(
    private _http : HttpClient,
  ) { }

  uploadService(data : any){
    return this._http.post(this.uploadUrl , data);
  }

  downloadService(code : any){
    return this._http.get(`${this.downloadUrl}/${code}`);
  }

}
