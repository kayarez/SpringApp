import { Component, OnInit } from '@angular/core';
import {EventService} from '../../services/event.service';
import {Event} from '../../models/Event';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.sass']
})
export class EventsComponent implements OnInit {
  eventName: string;
  events: Event[];
  page = 0;
  eventsInPage = 3;
  eventsSize: number;

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.getAllEvents();
    this.getEventsSize();
    this.eventService
      .getEvents()
      .subscribe( events => this.events = events);
  }

  getAllEvents(): void{
    this.eventService
      .getAllEvents(this.page, this.eventsInPage)
      .subscribe(events => this.events = events);
  }

  onChangePage(event: PageEvent) {
    this.page = event.pageIndex;
    this.eventsInPage = event.pageSize;
    this.getAllEvents();
  }

  getEventsSize(): void{
    this.eventService
      .getEventSize()
      .subscribe(size => this.eventsSize = size);
  }

  getEvents(): void {
    if (this.eventName === '') {
      this.ngOnInit();
      return;
    }
    this.eventService
      .getEventsByInputString(this.eventName, this.page, this.eventsInPage)
      .subscribe(events => this.events = events);
  }
}
