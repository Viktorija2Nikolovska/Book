package finki.ukim.mk.books.service;

import finki.ukim.mk.books.model.Author;
import finki.ukim.mk.books.model.Book;
import finki.ukim.mk.books.model.dto.BookDto;
import finki.ukim.mk.books.model.enums.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    List<Book>findAll();

    void deleteById(Long id);

    Optional<Book> findById(Long id);

    Optional<Book>addBook(String name, Category category, Author author, Integer avaliableCopies);


    Optional<Book>editBook(Long id,String name, Category category, Author author, Integer avaliableCopies);


    Optional<Book>save(BookDto bookDto);
    Optional<Book>edit(Long id,BookDto bookDto);



}
