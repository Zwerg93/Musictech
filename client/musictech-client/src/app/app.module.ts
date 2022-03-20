import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PlayerComponent } from './components/player/player.component';
import { UploadComponent } from './components/upload/upload.component';
import { LogInComponent } from './components/log-in/log-in.component';
import { PlaylistComponent } from './components/playlist/playlist.component';
import { SearchComponent } from './components/search/search.component';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatListModule} from "@angular/material/list";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatMenuModule} from "@angular/material/menu";
import {MaterialModule} from "./material.module";
import {MatSliderModule} from "@angular/material/slider";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { RegisterComponent } from './components/register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProfileComponent,
    PlayerComponent,
    UploadComponent,
    LogInComponent,
    PlaylistComponent,
    SearchComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbPaginationModule,
    NgbAlertModule,
    BrowserAnimationsModule,
    MatListModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MaterialModule,
    MatListModule,
    MatSliderModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
