package finki.ukim.mk.books.repository;


import finki.ukim.mk.books.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryJpaRepo  extends JpaRepository<Country, Long>{

  void deleteById(Long id);

  Optional<Country>findByName(String name);
}
