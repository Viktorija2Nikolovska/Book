package finki.ukim.mk.books.repository;

import finki.ukim.mk.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookJpaRepo extends JpaRepository<Book, Long> {

    List<Book>findAll();
    List<Book>findAllByName(String name);
    void deleteById(Long id);



}
