import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-delete-film',
  templateUrl: './delete-film.component.html',
  styleUrls: ['./delete-film.component.sass']
})
export class DeleteFilmComponent implements OnInit {
  film: Film = new Film();
  id: number;
  constructor(private filmService: FilmService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
  }

  deleteFilm(): void{
    this.filmService
      .deleteFilm(this.film)
      .subscribe(() => {
        this.router
          .navigate(['admin']);
      });
  }
}
