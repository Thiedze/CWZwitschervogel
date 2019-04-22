package de.cw.zwitschervogel.server.mapper;

import de.cw.zwitschervogel.server.domain.Tweet;
import de.cw.zwitschervogel.server.dto.TweetDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorMapper.class})
public interface TweetMapper {

  TweetMapper INSTANCE = Mappers.getMapper(TweetMapper.class);

  TweetDto tweetToTweetDto(Tweet tweet);

  List<TweetDto> tweetsToTweetDtos(List<Tweet> tweets);

}
