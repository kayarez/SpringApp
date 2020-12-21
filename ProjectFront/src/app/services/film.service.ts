import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Place} from '../models/Place';
import {Film} from '../models/Film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  constructor(private httpClient: HttpClient) {
  }

  getAllFilms(): Observable<Film[]> {
    return this.httpClient
      .get<Film[]>('http://localhost:8080/film').pipe();
  }


  saveFilm(film: Film): Observable<any> {
    return this.httpClient
      .post('http://localhost:8080/film', {name: film.name, description: film.description})
      .pipe();
  }
}
