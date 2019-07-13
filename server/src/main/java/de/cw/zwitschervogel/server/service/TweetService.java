package de.cw.zwitschervogel.server.service;

import de.cw.zwitschervogel.server.domain.Author;
import de.cw.zwitschervogel.server.domain.Tweet;
import de.cw.zwitschervogel.server.repository.AuthorRepository;
import de.cw.zwitschervogel.server.repository.TweetRepository;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweetService {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Value("#{'${profanity.filter}'.split(',')}")
  private List<String> profanityList;

  public List<Tweet> getTweets() {
    return tweetRepository.findAllByOrderByCreatedDesc();
  }

  @Transactional
  public void saveTweet(Tweet tweet) {
    Optional<Author> optional = authorRepository.findById(1L);

    if (optional.isPresent()) {
      tweet.setAuthor(optional.get());
      tweet.setLikes(0);
      tweet.setCreated(new GregorianCalendar());

      if (tweet.getContent() != null && profanityList.stream()
          .anyMatch(tweet.getContent().toLowerCase()::contains)) {
        for (String word : profanityList) {
          tweet.setContent(tweet.getContent()
              .replaceAll("(?i)" + word, new String(new char[word.length()]).replace("\0", "*")));
        }
      }

      tweetRepository.save(tweet);
    }
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
