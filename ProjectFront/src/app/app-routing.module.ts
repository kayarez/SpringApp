import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {EventsComponent} from './components/events/events.component';
import {EventComponent} from './components/event/event.component';
import {LogoutComponent} from './components/logout/logout.component';
import {AddEventComponent} from './components/add-event/add-event.component';
import {AddPlaceComponent} from './components/add-place/add-place.component';
import {AdminComponent} from './components/admin/admin.component';
import {FindComponent} from './components/find/find.component';
import {PlacesListComponent} from './components/places-list/places-list.component';
import {EventListComponent} from './components/event-list/event-list.component';
import {FilmComponent} from './components/scooter/film.component';
import {MyFilmComponent} from './components/scooter/my.film.component';


const routes: Routes = [
  {path: 'index', component: MyFilmComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'events', component: EventsComponent},
  {path: 'events/:id', component: EventComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'addEvent', component: AddEventComponent},
  {path: 'addFilm', component: AddPlaceComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'find', component: FindComponent},
  {path: 'placesList', component: PlacesListComponent},
  {path: 'updatePlace/:id', component: AddPlaceComponent},
  {path: 'eventsList', component: EventListComponent},
  {path: 'updateEvent/:id', component: AddEventComponent},
  {path: 'films', component: FilmComponent},
  {path: 'myscoots', component: MyFilmComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
