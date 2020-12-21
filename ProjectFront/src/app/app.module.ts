import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { IndexComponent } from './components/index/index.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { EventsComponent } from './components/events/events.component';
import { EventComponent } from './components/event/event.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AdminComponent } from './components/admin/admin.component';
import { AddEventComponent } from './components/add-event/add-event.component';
import { AddPlaceComponent } from './components/add-place/add-place.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTabsModule} from '@angular/material/tabs';
import {JwPaginationModule} from 'jw-angular-pagination';
import {MatPaginatorModule} from '@angular/material/paginator';
import { FindComponent } from './components/find/find.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import { PlacesListComponent } from './components/places-list/places-list.component';
import { EventListComponent } from './components/event-list/event-list.component';
import {HttpIntercepterBasicAuthService} from './services/http-intercepter-basic-auth-service.service';
import {FilmComponent} from './components/scooter/film.component';
import {MyFilmComponent} from './components/scooter/my.film.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent,
    EventsComponent,
    EventComponent,
    LogoutComponent,
    AdminComponent,
    AddEventComponent,
    AddPlaceComponent,
    FilmComponent,
    MyFilmComponent,
    FindComponent,
    PlacesListComponent,
    EventListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule,
    JwPaginationModule,
    MatPaginatorModule,
    MatSidenavModule,
    MatIconModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterBasicAuthService, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
