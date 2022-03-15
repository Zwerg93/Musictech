import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    document.getElementById("register")!.style.visibility = "hidden"

  }

  register() {
    document.getElementById("login")!.innerHTML = '<div class="pt-0">\n' +
      '    <section class="vh-100 gradient-custom">\n' +
      '      <div class="container py-5 h-100">\n' +
      '        <div class="row d-flex justify-content-center align-items-center h-100">\n' +
      '          <div class="col-12 col-md-8 col-lg-6 col-xl-5">\n' +
      '            <div class="card bg-dark text-white" style="border-radius: 1rem;">\n' +
      '              <div class="card-body p-5 text-center">\n' +
      '\n' +
      '                <div class="mb-md-5 mt-md-4 pb-5">\n' +
      '\n' +
      '                  <h2 class="fw-bold mb-2 text-uppercase">Login</h2>\n' +
      '                  <p class="text-white-50 mb-5">Please enter your Personal information</p>\n' +
      '\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="name" id="typeusernameXregister" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typeusernameXregister">Username</label>\n' +
      '                  </div>\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="name" id="typenameXregister" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typenameXregister">Name</label>\n' +
      '                  </div>\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="name" id="typelastnameXregister" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typelastnameXregister">Lastname</label>\n' +
      '                  </div>\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="email" id="typeEmailXregister" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typeEmailXregister">Email</label>\n' +
      '                  </div>\n' +
      '\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="password" id="typePasswordXregistr" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typePasswordXregistr">Password</label>\n' +
      '                  </div>\n' +
      '\n' +
      '                  <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>\n' +
      '\n' +
      '                  <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>\n' +
      '\n' +
      '                  <div class="d-flex justify-content-center text-center mt-4 pt-1">\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>\n' +
      '                  </div>\n' +
      '\n' +
      '                </div>\n' +
      '\n' +
      '                <div>\n' +
      '                  <p (click)="this.login();" class="mb-0">Have an account? <a  class="text-white-50 fw-bold">Sign Up</a></p>\n' +
      '                </div>\n' +
      '\n' +
      '              </div>\n' +
      '            </div>\n' +
      '          </div>\n' +
      '        </div>\n' +
      '      </div>\n' +
      '    </section>\n' +
      '  </div>';

  }

  login() {
    document.getElementById("login")!.innerHTML = '<div class="pt-0">\n' +
      '    <section class="vh-100 gradient-custom">\n' +
      '      <div class="container py-5 h-100">\n' +
      '        <div class="row d-flex justify-content-center align-items-center h-100">\n' +
      '          <div class="col-12 col-md-8 col-lg-6 col-xl-5">\n' +
      '            <div class="card bg-dark text-white" style="border-radius: 1rem;">\n' +
      '              <div class="card-body p-5 text-center">\n' +
      '\n' +
      '                <div class="mb-md-5 mt-md-4 pb-5">\n' +
      '\n' +
      '                  <h2 class="fw-bold mb-2 text-uppercase">Login</h2>\n' +
      '                  <p class="text-white-50 mb-5">Please enter your login and password!</p>\n' +
      '\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="name" id="typeEmailXlogin" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typeEmailXlogin">Username</label>\n' +
      '                  </div>\n' +
      '\n' +
      '                  <div class="form-outline form-white mb-4">\n' +
      '                    <input type="password" id="typePasswordXlogin" class="form-control form-control-lg"/>\n' +
      '                    <label class="form-label" for="typePasswordXlogin">Password</label>\n' +
      '                  </div>\n' +
      '\n' +
      '                  <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>\n' +
      '\n' +
      '                  <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>\n' +
      '\n' +
      '                  <div class="d-flex justify-content-center text-center mt-4 pt-1">\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>\n' +
      '                    <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>\n' +
      '                  </div>\n' +
      '\n' +
      '                </div>\n' +
      '\n' +
      '                <div>\n' +
      '                  <p (click)="this.register()" class="mb-0">Dont have an account? <a class="text-white-50 fw-bold">Sign Up</a></p>\n' +
      '                </div>\n' +
      '\n' +
      '              </div>\n' +
      '            </div>\n' +
      '          </div>\n' +
      '        </div>\n' +
      '      </div>\n' +
      '    </section>\n' +
      '  </div>'
  }
}
