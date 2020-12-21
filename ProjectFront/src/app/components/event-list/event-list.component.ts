import { Component, OnInit } from '@angular/core';
import {Event} from '../../models/Event';
import {EventService} from '../../services/event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.sass']
})
export class EventListComponent implements OnInit {
  eventSize: number;
  events: Event[];
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.getAllEvents();
  }

  getAllEvents(): void{
    this.eventService.getEventSize().subscribe(num => {
      this.eventService.getAllEvents(0, num).subscribe(events => this.events = events);
    });
  }

  deleteEvent(id: number): void{
    this.eventService.deleteEvent(id).subscribe();
  }

}
