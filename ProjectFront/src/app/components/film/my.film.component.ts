import {Component, OnInit} from '@angular/core';

import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-event-list',
  templateUrl: './my.film.component.html',
})
export class MyFilmComponent implements OnInit {
  films: Film[];

  constructor(private filmService: FilmService) {
  }

  ngOnInit(): void {
    this.getMyFilms();
  }

  getMyFilms(): void {
    this.filmService.getAllFilms().subscribe(num => {
      this.films = num;
      console.log(num);
    });
  }

}
