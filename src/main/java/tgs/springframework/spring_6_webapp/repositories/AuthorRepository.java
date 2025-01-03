package tgs.springframework.spring_6_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tgs.springframework.spring_6_webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
