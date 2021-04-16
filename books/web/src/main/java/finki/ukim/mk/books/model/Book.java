package finki.ukim.mk.books.model;


import finki.ukim.mk.books.model.enums.Category;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer avaliableCopies;

    public Book() {
    }

    public Book( String name, Category category, Author author, Integer avaliableCopies) {

        this.name = name;
        this.category = category;
        this.author = author;
        this.avaliableCopies = avaliableCopies;
    }


}
