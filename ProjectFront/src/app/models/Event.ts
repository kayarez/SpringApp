import {Place} from './Place';
import {Comment} from './Comment';

export class Event{
  id: number;
  name: string;
  startDate: Date;
  finishDate: Date;
  place: Place;
  comments: Comment[];
}
