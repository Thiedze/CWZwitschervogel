import {Component, OnInit} from '@angular/core';
import {TweetService} from '../../service/tweet.service';
import {Tweet} from '../../domain/tweet';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {

  public tweets: Tweet[];
  public content: string;

  constructor(private tweetService: TweetService) {
    this.content = '';
  }

  ngOnInit() {
    this.loadTweets();
  }

  public addLike(tweetId: number): void {
    this.tweetService.addLike(tweetId).subscribe(result => {
      this.loadTweets();
    });

  }

  public createTweet(): void {
    if (this.content !== undefined && this.content != null && this.content.length > 3) {
      this.tweetService.createTweet(this.content).subscribe(result => {
        this.content = '';
        this.loadTweets();
      });
    }
  }

  private loadTweets(): void {
    this.tweetService.get().subscribe(tweets => {
      this.tweets = tweets;
    });
  }

}
