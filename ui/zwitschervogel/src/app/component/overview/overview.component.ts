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

  constructor(private tweetService: TweetService) {
  }

  ngOnInit() {
    this.tweetService.get().subscribe(tweets => {
      this.tweets = tweets;
    });
  }

}
