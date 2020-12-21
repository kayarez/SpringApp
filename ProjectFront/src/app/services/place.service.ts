import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Place} from '../models/Place';

@Injectable({
  providedIn: 'root'
})
export class PlaceService {
  constructor(private httpClient: HttpClient) { }

  getAllPlacesNames(): Observable<string[]>{
    return this.httpClient
      .get<string[]>('http://localhost:8080/rest/api/v1/places/names');
  }

  savePlace(name: string, country: string, city: string, street: string, placeNumber: number): Observable<any>{
    return this.httpClient
      .post('http://localhost:8080/rest/api/v1/places', {name, country, city, street, placeNumber})
      .pipe();
  }

  getAllCountries(): Observable<string[]>{
    return this.httpClient
      .get<string[]>('http://localhost:8080/rest/api/v1/places/countries')
      .pipe();
  }

  getAllPlacenamesByCountryName(countryName: string): Observable<string[]>{
    return this.httpClient
      .get<string[]>(`http://localhost:8080/rest/api/v1/places/placeNames?countryName=${countryName}`)
      .pipe();
  }

  getAllPlaces(): Observable<Place[]>{
    return this.httpClient
      .get<Place[]>(`http://localhost:8080/rest/api/v1/places`);
  }

  getPlaceById(id: number): Observable<Place>{
    return this.httpClient
      .get<Place>(`http://localhost:8080/rest/api/v1/places/${id}`);
  }

  deletePlace(id: number): Observable<any>{
    return this.httpClient
      .delete(`http://localhost:8080/rest/api/v1/places/${id}`);
  }

  updatePlace(place: Place, id: number): Observable<any>{
    return this.httpClient
      .put(`http://localhost:8080/rest/api/v1/places/${id}`, place);
  }
}
