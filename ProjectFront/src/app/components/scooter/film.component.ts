import {Component, OnInit} from '@angular/core';
import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-event-list',
  templateUrl: './film.component.html',
})
export class FilmComponent implements OnInit {
  films: Film[];
  editScooter: Film;
  duration: number;

  constructor(private filmService: FilmService) {
  }

  ngOnInit(): void {
    this.getAllScooters();
  }

  getAllScooters(): void {
    this.filmService.getAllFilms().subscribe(num => {
      this.films = num;
      console.log(num);
    });
  }
}
