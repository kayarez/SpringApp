import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Comment} from '../models/Comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private httpClient: HttpClient) { }

  getAllCommentByEventId(id: number): Observable<Comment[]>{
    return this.httpClient
      .get<Comment[]>(`http://localhost:8080/rest/api/v1/comments/${id}`);
  }

  addComment(rating: number, text: string, file: File[], id: number): Observable<any>{
    const formData: FormData = new FormData();
    // @ts-ignore
    for (const x of file){
      formData.append('file', x, x.name);
    }
    // @ts-ignore
    formData.append('rating', rating);
    formData.append('text', text);
    // @ts-ignore
    formData.append('eventId', id);
    return this.httpClient
      .post('http://localhost:8080/rest/api/v1/comments', formData)
      .pipe();
  }
}
