import { Component, OnInit } from '@angular/core';
import {ProducerService} from '../../services/producer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Producer} from '../../models/Producer';

@Component({
  selector: 'app-add-producer',
  templateUrl: './add-producer.component.html',
  styleUrls: ['./add-producer.component.sass']
})
export class AddProducerComponent implements OnInit {
  producer: Producer = new Producer();
  id: number;
  constructor(private producerService: ProducerService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
  }

  saveProducer(): void{
    this.producerService
      .saveProducer(this.producer)
      .subscribe(() => {
        this.router
          .navigate(['admin']);
      });
  }
}

