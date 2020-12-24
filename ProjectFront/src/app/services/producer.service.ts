import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Producer} from '../models/Producer';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProducerService {
  constructor(private httpClient: HttpClient) {
  }

  getAllProducers(): Observable<Producer[]> {
    return this.httpClient
      .get<Producer[]>('http://localhost:8080/producer').pipe();
  }


  saveProducer(producer: Producer): Observable<any> {
    return this.httpClient
      .post('http://localhost:8080/rest/api/v1/addProducer/', {name: producer.name, rating: producer.rating})
      .pipe();
  }
  // updateFilm(producer: Producer): Observable<any> {
  //   return this.httpClient
  //     .post('http://localhost:8080/film', {id: film.id, name: film.name, description: film.description})
  //     .pipe();
  // }
}
