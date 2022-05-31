import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

var test: boolean;

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  private errors: any;
  private user: any;

  constructor(private http: HttpClient) {
  }


  ngOnInit(): void {
    'use strict'

    var forms = document.querySelectorAll('.needs-validation')

    Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            test = false;
            event.preventDefault()
            event.stopPropagation()
            //console.log("nothing is valid :)")
          } else {
            test = true;
           // console.log("everyting is valid :)")
          }

          form.classList.add('was-validated')
        }, false)
      })
  }


  username: string = '';
  name: string = '';
  lastname: string = '';
  eMail: string = '';
  password: string = '';


  test3() {
    if (test) {

      this.username = (<HTMLInputElement>document.getElementById("validationusername")).value;
      this.name = (<HTMLInputElement>document.getElementById("validationCustom01")).value;
      this.lastname = (<HTMLInputElement>document.getElementById("validationCustom02")).value;
      this.eMail = (<HTMLInputElement>document.getElementById("validationEmail")).value;
      this.password = (<HTMLInputElement>document.getElementById("validationPassword")).value;
      //this.name = (<HTMLInputElement>document.getElementById("validationCustom01")).value;

      //console.log("wuhu")
      var data = {
        email: this.eMail,
        lastname: this.lastname,
        name: this.name,
        password: this.password,
        username: this.username
      };
      ///api/user
      //http://localhost:8080
      this.http.post('/api/user', data).subscribe(
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

          const data2 = {
            id: 0,
            name: 'fav',
          };


          ///api/user/getuser/
          //http://localhost:8080/user/getuser/
          this.http.get('/api/user/getuser/' + this.username).toPromise().then((response: any) => {
            this.user = response;
            //http://localhost:8080/user/add/
            this.http.post('/api/user/add/' + this.user.id, data2).subscribe();
            //console.log(this.user.id + "Userid");

          })

          document.getElementById("showresult")!.innerHTML = "<fieldset>\n" +
            "    <div >\n" +
            "<p>Succes!</p>" +
            "    </div>\n" +
            "  </fieldset>"

          sessionStorage.setItem('login', 'true');
          sessionStorage.setItem('username', this.username);

        });
    }


  }


}

