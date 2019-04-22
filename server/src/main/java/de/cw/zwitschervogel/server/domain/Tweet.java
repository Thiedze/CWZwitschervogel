package de.cw.zwitschervogel.server.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tweet")
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tweetid")
  private Long id;

  @OneToOne(cascade = {CascadeType.ALL})
  private Author author;


  private String content;

  private Integer likes;

}