package jpabook.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;

}
