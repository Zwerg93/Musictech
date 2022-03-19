import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {
  //password: String;

  password: String;
 // username: String;

  constructor() { }

  ngOnInit(): void {
    document.getElementById("register")!.style.visibility = "hidden"

  }


  username: string = '';

  clickme() {
    console.log('it does nothing',this.username);
  }

  register() {

  }

  login() {
   console.log(this.username);
  }
}
