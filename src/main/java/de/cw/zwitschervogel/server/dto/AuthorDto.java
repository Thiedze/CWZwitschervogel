package de.cw.zwitschervogel.server.dto;

import java.util.GregorianCalendar;
import lombok.Data;

@Data
public class AuthorDto {

  private Long id;

  private String name;

  private GregorianCalendar memberSince;

}
