package de.cw.zwitschervogel.server.dto;

import java.util.GregorianCalendar;
import lombok.Data;

@Data
public class TweetDto {

  private Long id;

  private AuthorDto author;

  private String content;

  private Integer likes;

  private GregorianCalendar created;

}
