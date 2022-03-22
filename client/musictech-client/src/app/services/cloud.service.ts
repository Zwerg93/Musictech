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
      this.http.get('http://172.24.0.3:8080/song/all').toPromise().then((response: any) => {
      this.itemList = response;
      console.table(this.itemList);
    });
  }

  getFiles() {
    return of(this.itemList);
  }

}


