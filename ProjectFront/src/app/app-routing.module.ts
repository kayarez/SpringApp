import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {LogoutComponent} from './components/logout/logout.component';
import {AddProducerComponent} from './components/add-producer/add-producer.component';
import {AddFilmComponent} from './components/add-film/add-film.component';
import {UpdateFilmComponent} from './components/update-film/update-film.component';
import {DeleteFilmComponent} from './components/delete-film/delete-film.component';
import {AdminComponent} from './components/admin/admin.component';
import {MyFilmComponent} from './components/film/my.film.component';
import {MyProducerComponent} from './components/producer/my.producer.component';


const routes: Routes = [
  {path: 'index', component: MyFilmComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'addFilm', component: AddFilmComponent},
  {path: 'updateFilm', component: UpdateFilmComponent},
  {path: 'deleteFilm', component: DeleteFilmComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'addProducer', component: AddProducerComponent},
  {path: 'producer', component: MyProducerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
