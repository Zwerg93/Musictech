import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CloudService {

  constructor(private http: HttpClient) {
  }

  public itemList: { url: string, name: string, artist: string }[] = [];

  onload() {
      this.http.get('http://192.168.0.22:8080/song/all').toPromise().then((response: any) => {
      this.itemList = response;
      console.table(this.itemList);
    });
  }

  getFiles() {
    return of(this.itemList);
  }

}


