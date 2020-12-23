import {Component, OnInit} from '@angular/core';

import {ProducerService} from '../../services/producer.service';
import {Producer} from '../../models/Producer';

@Component({
  selector: 'app-producer-list',
  templateUrl: './my.producer.component.html',
})
export class MyProducerComponent implements OnInit {
  producers: Producer[];

  constructor(private producerService: ProducerService) {
  }

  ngOnInit(): void {
    this.getMyProducers();
  }

  getMyProducers(): void {
    this.producerService.getAllProducers().subscribe(num => {
      this.producers = num;
      console.log(num);
    });
  }

}
