package tgs.springframework.spring_6_webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tgs.springframework.spring_6_webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}