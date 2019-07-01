package de.cw.zwitschervogel.server.mapper;

import de.cw.zwitschervogel.server.domain.Author;
import de.cw.zwitschervogel.server.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

  AuthorDto authorToAuthorDto(Author author);

}