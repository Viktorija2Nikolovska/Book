package finki.ukim.mk.books.service.Impl;

import finki.ukim.mk.books.model.Author;
import finki.ukim.mk.books.model.Book;
import finki.ukim.mk.books.model.dto.BookDto;
import finki.ukim.mk.books.model.enums.Category;
import finki.ukim.mk.books.repository.BookJpaRepo;
import finki.ukim.mk.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookJpaRepo bookJpaRepo;

    public BookServiceImpl(BookJpaRepo bookJpaRepo) {
        this.bookJpaRepo = bookJpaRepo;
    }

    @Override
    public List<Book> findAll() {
        return this.bookJpaRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.bookJpaRepo.deleteById(id);

    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookJpaRepo.findById(id);
    }

    @Override
    public Optional<Book> addBook(String name, Category category, Author author, Integer avaliableCopies) {
        return Optional.of(this.bookJpaRepo.save(new Book(name,category,author,avaliableCopies)));
    }

    @Override
    public Optional<Book> editBook(Long id, String name, Category category, Author author, Integer avaliableCopies) {
       Book book=this.bookJpaRepo.findById(id).orElseThrow();
       book.setName(name);
       book.setCategory(category);
       book.setAuthor(author);
       book.setAvaliableCopies(avaliableCopies);
       this.bookJpaRepo.save(book);
       return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {


        this.bookJpaRepo.deleteByName(productDto.getName());
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),bookDto.getAuthor(),bookDto.getAvaliableCopies());
        this.bookJpaRepo.save(book);
        

        this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(book));
        return Optional.of(book);
        


    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book= this.bookJpaRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        book.setName(bookDto.getName());
        book.setAvaliableCopies(bookDto.getAvaliableCopies());
        book.setAuthor(bookDto.getAuthor());
        book.setCategory(book.setCategory());



        this.bookJpaRepo.save(book);
        return Optional.of(book);
       
    }
}
