package jpabook.start.chmodel.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@DiscriminatorValue("book")
@Entity
@Table(name = "book")
public class Book extends Item {

    private String author;
    private String isbn;
}
