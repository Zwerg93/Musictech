import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {
  private errors: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  selectetFile: any;

  onFIleSelected(event) {
    console.log(event)
    this.selectetFile = <File>event.target.files[0];
  }

  onUpload() {
    var output =this.selectetFile.name.replace(/[\[\]']+/g,'');

    const fd = new FormData();


    fd.append('uploadedFile', this.selectetFile, output);


    this.http.post('http://localhost:8080/uploadFile/upload', fd).subscribe(
      result => {
      },
      error => {
        this.errors = error;
        document.getElementById("showresult")!.innerHTML = "<fieldset>\n" +
          "    <div >\n" +
          "<p>Error. Pls try again!</p>" +
          "    </div>\n" +
          "  </fieldset>"
      },
      () => {
        document.getElementById("showresult")!.innerHTML = "<fieldset>\n" +
          "    <div >\n" +
          "<p>Succes!</p>" +
          "    </div>\n" +
          "  </fieldset>"
      }
    );

  }

  download() {
    var str = (<HTMLInputElement>document.getElementById("link")).value;
    console.log(str)

    var re ="https://www.youtube.com/watch?v=";

   // var str1 = "Apples are round, and apples are juicy.";
    var newstr = str.replace(re, "");
    console.log(newstr)
    //https://www.youtube.com/watch?v=-yyq-Kr06D8



    document.getElementById("iframe")!.innerHTML = '<iframe id="iframe" src="https://www.yt-download.org/api/button/mp3/' + newstr + '" width="100%" height="100px" scrolling="no" style="border:none;"></iframe>'

  }
}
