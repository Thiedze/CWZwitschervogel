package de.cw.zwitschervogel.server.repository;

import de.cw.zwitschervogel.server.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
