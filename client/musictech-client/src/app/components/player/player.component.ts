import {Component} from '@angular/core';
import {AudioService} from '../../services/audio.service';
import {CloudService} from '../../services/cloud.service';
import {timer} from "rxjs";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent {
  files: Array<any> = [];
  tmpFiles: Array<any> = [];
  test = true
  isplaying = false;
  state;
  currentFile: any = {};
  itemList: any;
  user: any;
  cloudService: CloudService;
  searchstring: String;

  /*
    @HostListener('window:keyup', ['$event'])
    keyEvent(event: KeyboardEvent) {
      if (event.keyCode == KEY_CODE.SPACE) {
        if (this.isplaying){
          this.pause();
        }else{
          this.play();
        }
      }else if(event.keyCode == KEY_CODE.N_BUTTON){
        this.next()
      }else if(event.keyCode == KEY_CODE.P_BUTTON){
        this.previous()
      }else if(event.keyCode == KEY_CODE.LEFT_ARROW){
        console.log(this.audioService.audioObj.currentTime);
        if(this.audioService.audioObj.currentTime>10){
          this.audioService.audioObj.currentTime -=10;
        }
      }else if(event.keyCode == KEY_CODE.RIGHT_ARROW){
        console.log(this.audioService.audioObj.currentTime);
        console.log(this.state.readableDuration)
        if(this.audioService.audioObj.currentTime<this.state.readableDuration+10){
          this.audioService.audioObj.currentTime +=10;

        }
      }
    }



   */
  private errors: any;


  constructor(private audioService: AudioService, cloudService: CloudService, private http: HttpClient) {
    cloudService.onload();
    timer(400).subscribe(x => {
      this.getPlaylists()
      cloudService.getFiles().subscribe(files => {
        this.files = files
        this.tmpFiles = files;
      });
    })

    this.audioService.getState()
      .subscribe(state => {
        this.state = state;
      });
  }

  playStream(url) {
    this.audioService.playStream(url)
      .subscribe(events => {
      });
  }

  openFile(file, index) {
    this.currentFile = {index, file};
    this.audioService.stop();
    this.playStream(file.url);
  }

  pause() {
    this.audioService.pause();
    this.isplaying = false;
  }

  play() {
    this.audioService.play();
    this.isplaying = true;
  }

  random() {
    const index = this.randomIntFromInterval(0, this.files.length - 1);
    const file = this.files[index];
    this.openFile(file, index);
    console.log(index);
  }

  stop() {
    this.audioService.stop();
  }

  next() {
    const index = this.currentFile.index + 1;
    const file = this.files[index];
    this.openFile(file, index);
  }

  previous() {
    const index = this.currentFile.index - 1;
    const file = this.files[index];
    this.openFile(file, index);
  }

  isFirstPlaying() {
    return this.currentFile.index === 0;
  }

  isLastPlaying() {
    return this.currentFile.index === this.files.length - 1;
  }

  onSliderChangeEnd(change) {
    this.audioService.seekTo(change.value);
  }

  autoplayfunc(test) {
    this.audioService.autoplayfunc(test);
  };

  randomIntFromInterval(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
  }

  myMethod(event: any) {
    this.files = this.tmpFiles.filter((file: { name: string }) => {
      return file.name.toLowerCase().includes(this.searchstring.toLowerCase());
    })
  }

  cancelSearch() {
    this.files = this.tmpFiles;
    (<HTMLInputElement>document.getElementById("searchinput")).value = '';
  }

  getPlaylists() {
    if (sessionStorage.getItem('username') != null) {

      this.http.get('http://172.24.0.3:8080/user/getPlalist/' + sessionStorage.getItem('username')).toPromise().then((response: any) => {
        this.itemList = response;

        console.table(this.itemList);

        //  this.files = this.itemList[0].songList;
      })
    }
  }


  getSongsFromPlalist(id: number) {
    //console.log(name -1);
    console.log(id + "id ")
    console.table(this.itemList[id].songList)
    this.files = this.itemList[id].songList;

  }


  allSongs() {
    this.files = this.tmpFiles;
  }

   addToFavourits(currentFile: any) {
    if (sessionStorage.getItem('username') != null) {
      console.log(sessionStorage.getItem('username'))
      this.http.get('http://172.24.0.3:8080/user/getuser/' + sessionStorage.getItem('username')).toPromise().then((response: any) => {
        this.user = response;
        this.asyncaddTofav(currentFile);
        console.log(this.user.id + "Userid");

      })


    } else {
      console.log("not logged in")
    }
    console.log(currentFile.file.id)
  }

  asyncaddTofav(currentFile: any){

    this.http.post('http://172.24.0.38080/user/add/' + this.user.id + '/' + currentFile.file.id + '', null).subscribe(
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

}

export enum KEY_CODE {
  UP_ARROW = 38,
  DOWN_ARROW = 40,
  RIGHT_ARROW = 39,
  LEFT_ARROW = 37,
  SPACE = 32,
  N_BUTTON = 78,
  P_BUTTON = 80

}
