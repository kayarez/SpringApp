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
import { LogoutComponent } from './components/logout/logout.component';
import { AdminComponent } from './components/admin/admin.component';
import { AddProducerComponent } from './components/add-producer/add-producer.component';
import { AddFilmComponent } from './components/add-film/add-film.component';
import { UpdateFilmComponent } from './components/update-film/update-film.component';
import { DeleteFilmComponent } from './components/delete-film/delete-film.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTabsModule} from '@angular/material/tabs';
import {JwPaginationModule} from 'jw-angular-pagination';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {HttpIntercepterBasicAuthService} from './services/http-intercepter-basic-auth-service.service';
import {MyFilmComponent} from './components/film/my.film.component';
import {MyProducerComponent} from './components/producer/my.producer.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    AdminComponent,
    AddProducerComponent,
    AddFilmComponent,
    UpdateFilmComponent,
    DeleteFilmComponent,
    MyFilmComponent,
    MyProducerComponent
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
