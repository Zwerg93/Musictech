import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {
  private errors: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {

    if (sessionStorage.getItem('login') == null) {
      null;
      //console.log("not logged in")
    } else {
      document.getElementById("register")!.innerHTML = sessionStorage.getItem('login')! + " Loged in as: " + sessionStorage.getItem('username');
      //console.log("succes")
    }

  }
  username: string = '';
  password: string = '';
  clickme() {
    this.username = (<HTMLInputElement>document.getElementById("typeEmailXlogin")).value;
    this.password = (<HTMLInputElement>document.getElementById("typePasswordXlogin")).value;

///api/user/autorize/
    //http://localhost:8080
    this.http.post('http://localhost:8080/user/autorize/' + this.username + '/' + this.password, null).subscribe(
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
        sessionStorage.setItem('login', 'true');
        sessionStorage.setItem('username', this.username);
      }
    );
  }
}
