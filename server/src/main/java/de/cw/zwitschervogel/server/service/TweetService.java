package de.cw.zwitschervogel.server.service;

import de.cw.zwitschervogel.server.domain.Author;
import de.cw.zwitschervogel.server.domain.Tweet;
import de.cw.zwitschervogel.server.repository.AuthorRepository;
import de.cw.zwitschervogel.server.repository.TweetRepository;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweetService {


  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private AuthorRepository authorRepository;

  public List<Tweet> getTweets() {
    return tweetRepository.findAllByOrderByCreatedDesc();
  }

  @Transactional
  public void saveTweet(Tweet tweet) {
    Author author = authorRepository.findById(1L).get();
    tweet.setAuthor(author);
    tweet.setLikes(0);
    tweet.setCreated(new GregorianCalendar());
    tweetRepository.save(tweet);
  }

  @Transactional
  public void addLike(Long tweetId) {
    Optional<Tweet> tweetOptional = tweetRepository.findById(tweetId);
    if (tweetOptional.isPresent()) {
      tweetOptional.get().setLikes(tweetOptional.get().getLikes() + 1);
      tweetRepository.save(tweetOptional.get());
    }
  }

}
