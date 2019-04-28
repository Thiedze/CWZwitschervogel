package de.cw.zwitschervogel.server.repository;

import de.cw.zwitschervogel.server.domain.Tweet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

  List<Tweet> findAllByOrderByCreatedDesc();

}
