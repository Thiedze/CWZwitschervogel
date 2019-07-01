package de.cw.zwitschervogel.server.controller;

import de.cw.zwitschervogel.server.domain.Tweet;
import de.cw.zwitschervogel.server.service.TweetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class TweetController {

  @Autowired
  private TweetService tweetService;

  @RequestMapping(value = "/tweets", method = RequestMethod.GET)
  public List<Tweet> getTweets() {
    return tweetService.getTweets();
  }

}