package finki.ukim.mk.books.model.dto;

import finki.ukim.mk.books.model.Author;
import finki.ukim.mk.books.model.enums.Category;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Data
public class BookDto {

    private String name;


    private Category category;


    private Author author;

    private Integer avaliableCopies;

    public BookDto() {

    }


    public BookDto(String name, Category category, Author author, Integer avaliableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.avaliableCopies = avaliableCopies;
    }
}
