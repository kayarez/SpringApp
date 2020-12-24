import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
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
      .post('http://localhost:8080/rest/api/v1/addFilm/', {name: film.name, description: film.description})
      .pipe();
  }
  updateFilm(film: Film): Observable<any> {
    return this.httpClient
      .put('http://localhost:8080/rest/api/v1/updateFilm/', {id: film.id, name: film.name, description: film.description})
      .pipe();
  }
  deleteFilm(film: Film): Observable<any> {
    return this.httpClient
      .get('http://localhost:8080/deletefilm?id=' + film.id)
      .pipe();
  }
}
