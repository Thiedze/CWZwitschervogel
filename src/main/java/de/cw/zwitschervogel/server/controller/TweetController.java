package de.cw.zwitschervogel.server.controller;

import de.cw.zwitschervogel.server.dto.TweetDto;
import de.cw.zwitschervogel.server.mapper.TweetMapper;
import de.cw.zwitschervogel.server.service.TweetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class TweetController {

  @Autowired
  private TweetService tweetService;

  @RequestMapping(value = "/tweets")
  public List<TweetDto> tweets() {
    return TweetMapper.INSTANCE.tweetsToTweetDtos(tweetService.tweets());
  }

}
