import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Event} from '../models/Event';
import {BehaviorSubject, Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EventService {
  events: BehaviorSubject<Event[]> = new BehaviorSubject<Event[]>(null);

  constructor(private httpClient: HttpClient) { }

  getAllEvents(page: number, eventsInPage: number): Observable<Event[]>{
    return this.httpClient
      .get<Event[]>(`http://localhost:8080/rest/api/v1/events?page=${page}&&size=${eventsInPage}`);
  }

  getEventSize(): Observable<number>{
    return this.httpClient
      .get<number>(`http://localhost:8080/rest/api/v1/events/length`);
  }

  getEventById(id: number): Observable<Event>{
    return this.httpClient
      .get<Event>(`http://localhost:8080/rest/api/v1/events/${id}`);
  }

  getEventsByInputString(input: string, page: number, eventsInPage: number): Observable<Event[]>{
     return this.httpClient
      .get<Event[]>(`http://localhost:8080/rest/api/v1/events/input?input=${input}&&page=${page}&&size=${eventsInPage}`)
       .pipe();
  }

  saveEvent(name: string, startDate: Date, finishDate: Date, placeName: string): Observable<any>{
    return this.httpClient
      .post('http://localhost:8080/rest/api/v1/events', {name, startDate, finishDate, placeName})
      .pipe();
  }

  getAllEventsByParams(country: string, place: string, startDate: Date, finishDate: Date): Observable<Event[]>{
    let query = ``;
    if (country !== undefined) { query += `country=${country}&&`; }
    if (place !== undefined) { query += `place=${place}&&`; }
    if (startDate !== undefined) {
      query += `startDate=${startDate}&&`;
    }
    if (finishDate !== undefined) {
      query += `finishDate=${finishDate}&&`;
    }
    query = query.substring(0, query.length - 2);
    return this.httpClient
      .get<Event[]>(`http://localhost:8080/rest/api/v1/events/params?${query}`);
  }

  receiveEvents(country: string, place: string, startDate: Date, finishDate: Date): Observable<Event[]>{
    this.getAllEventsByParams(country, place, startDate, finishDate)
      .subscribe(events => this.events.next(events));
    return this.events
      .asObservable();
  }

  getEvents(): Observable<Event[]>{
    return this.events;
  }

  deleteEvent(id: number): Observable<any>{
    return this.httpClient
      .delete(`http://localhost:8080/rest/api/v1/events/${id}`);
  }

  updatePlace(event: object, id: number): Observable<any>{
    return this.httpClient
      .put(`http://localhost:8080/rest/api/v1/events/${id}`, event);
  }
}
