import {User} from './User';
import {File} from './File';

export class Comment {
  id: number;
  rating: number;
  text: string;
  user: User;
  file: File[];
}
