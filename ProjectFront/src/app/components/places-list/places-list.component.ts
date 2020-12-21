import { Component, OnInit } from '@angular/core';
import {Place} from '../../models/Place';
import {PlaceService} from '../../services/place.service';

@Component({
  selector: 'app-places-list',
  templateUrl: './places-list.component.html',
  styleUrls: ['./places-list.component.sass']
})
export class PlacesListComponent implements OnInit {

  places: Place[];
  constructor(private placeService: PlaceService) { }

  ngOnInit(): void {
    this.getAllPlaces();
  }

  getAllPlaces(): void{
    this.placeService.getAllPlaces().subscribe(places => this.places = places);
  }

  deletePlace(id: number): void{
    this.placeService.deletePlace(id).subscribe();
    this.getAllPlaces();
  }

}
