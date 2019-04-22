import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Tweet} from '../domain/tweet';

@Injectable({
  providedIn: 'root'
})
export class TweetService {

  constructor(private httpClient: HttpClient) {
  }

  get(): Observable<Tweet[]> {
    return this.httpClient.get<Tweet[]>('tweets');
  }
}
