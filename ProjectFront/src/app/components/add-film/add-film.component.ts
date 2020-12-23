import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.sass']
})
export class AddFilmComponent implements OnInit {
  film: Film = new Film();
  id: number;
  constructor(private filmService: FilmService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
  }

  saveFilm(): void{
      this.filmService
        .saveFilm(this.film)
        .subscribe(() => {
          this.router
            .navigate(['admin']);
        });
    }
}
