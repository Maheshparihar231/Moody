import { Component } from '@angular/core';
import { UploadService } from 'src/app/services/upload/upload.service';

@Component({
  selector: 'app-uploadbox',
  templateUrl: './uploadbox.component.html',
  styleUrls: ['./uploadbox.component.css']
})
export class UploadboxComponent {
  constructor(private _uploadService : UploadService){}

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      console.log('Selected File:', file);
      this._uploadService.uploadService(file).subscribe(res=>{
        console.log(res);
      });
      // const fileName = file.name;
      // console.log('File Name:', fileName);
      // const fileSize = file.size;
      // console.log('File Size (bytes):', fileSize);
      // const fileType = file.type;
      // console.log('File Type:', fileType);
    } else {
      console.log('No file selected.');
    }
  }
}
