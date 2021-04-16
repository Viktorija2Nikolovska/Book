package finki.ukim.mk.books.repository;

import finki.ukim.mk.books.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorJpaRepo extends JpaRepository<Author,Long> {

    List<Author> findAllByName(String name);

    void deleteById(Long id);
}
