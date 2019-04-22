package de.cw.zwitschervogel.server.mapper;

import de.cw.zwitschervogel.server.domain.Author;
import de.cw.zwitschervogel.server.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

  AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

  AuthorDto authorToAuthorDto(Author author);

}