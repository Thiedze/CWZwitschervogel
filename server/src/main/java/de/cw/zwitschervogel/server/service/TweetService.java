package de.cw.zwitschervogel.server.service;

import de.cw.zwitschervogel.server.domain.Tweet;
import de.cw.zwitschervogel.server.repository.TweetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {


  @Autowired
  private TweetRepository tweetRepository;

  public List<Tweet> tweets() {
    return tweetRepository.findAllByOrderByCreatedDesc();
  }

}
