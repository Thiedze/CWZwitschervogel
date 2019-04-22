package de.cw.zwitschervogel.server.dto;

import lombok.Data;

@Data
public class TweetDto {

  private Long id;

  private AuthorDto author;

  private String content;

  private Integer likes;

}
