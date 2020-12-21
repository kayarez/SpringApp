import { Component, OnInit } from '@angular/core';
import {PlaceService} from '../../services/place.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Place} from '../../models/Place';
import {FilmService} from '../../services/film.service';
import {Film} from '../../models/Film';

@Component({
  selector: 'app-add-place',
  templateUrl: './add-place.component.html',
  styleUrls: ['./add-place.component.sass']
})
export class AddPlaceComponent implements OnInit {
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
