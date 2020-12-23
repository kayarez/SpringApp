import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-update-film',
  templateUrl: './update-film.component.html',
  styleUrls: ['./update-film.component.sass']
})
export class UpdateFilmComponent implements OnInit {
  film: Film = new Film();
  id: number;
  constructor(private filmService: FilmService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
  }

  updateFilm(): void{
    this.filmService
      .updateFilm(this.film)
      .subscribe(() => {
        this.router
          .navigate(['admin']);
      });
  }
}
