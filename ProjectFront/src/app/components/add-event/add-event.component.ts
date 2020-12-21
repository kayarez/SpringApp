import { Component, OnInit } from '@angular/core';
import {PlaceService} from '../../services/place.service';
import {EventService} from '../../services/event.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.sass']
})
export class AddEventComponent implements OnInit {
  placeNames: string[];
  event = {name: '', startDate: new Date(), finishDate: new Date(), placeName: ''};
  id: number;
  isUpdate: boolean;

  constructor(private placeService: PlaceService,
              private eventService: EventService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    if (this.id !== undefined){
      this.isUpdate = true;
      this.eventService
        .getEventById(this.id)
        .subscribe(event => {
          this.event.name = event.name;
          this.event.startDate = event.startDate;
          this.event.finishDate = event.finishDate;
          this.event.placeName = event.place.name;
      });
      this.getAllPlaceNames();
    }else{
      this.getAllPlaceNames();
    }
  }

  getAllPlaceNames(): void{
    this.placeService
      .getAllPlacesNames()
      .subscribe(placeNames => this.placeNames = placeNames);
  }

  addEvent(): void{
    if (this.id !== undefined){
      this.eventService
        .updatePlace(this.event, this.id)
        .subscribe(() => {
          this.router
            .navigate(['/eventsList']);
      });
    } else {
      this.eventService
        .saveEvent(this.event.name, this.event.startDate, this.event.finishDate, this.event.placeName)
        .subscribe(() => {
          this.router
            .navigate(['/events']);
        });
    }
  }


}
