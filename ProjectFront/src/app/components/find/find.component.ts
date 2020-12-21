import {Component, OnInit} from '@angular/core';
import {Event} from '../../models/Event';
import {EventService} from '../../services/event.service';
import {PlaceService} from '../../services/place.service';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.sass']
})
export class FindComponent implements OnInit {
  placeName: string;
  placeCountry: string;
  startDate: Date;
  finishDate: Date;
  placeCountries: string[];
  placeNames: string[];

  events: Event[];

  constructor(private eventService: EventService, private placeService: PlaceService) {

  }

  ngOnInit(): void {
    this.getAllCountries();
    this.getAllPlaceNames();
  }

  find(): void{
    this.eventService
      .receiveEvents(this.placeCountry, this.placeName, this.startDate, this.finishDate);
    this.placeCountry = undefined;
    this.placeCountries = undefined;
    this.placeName = undefined;
    this.placeNames = undefined;
    this.startDate = undefined;
    this.finishDate = undefined;
    this.getAllCountries();
    this.getAllPlaceNames();
  }

  getAllCountries(): void{
    this.placeService
      .getAllCountries()
      .subscribe(countries => this.placeCountries = countries);
  }

  getAllPlaceCountries(): void{
    this.placeService
      .getAllPlacenamesByCountryName(this.placeCountry)
      .subscribe(places => this.placeNames = places);
  }

  getAllPlaceNames(): void{
    this.placeService
      .getAllPlacesNames()
      .subscribe(placeNames => this.placeNames = placeNames);
  }
}
