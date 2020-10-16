package jpabook.start.chmodel.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@DiscriminatorValue("movie")
@Entity
@Table(name = "movie")
public class Movie extends Item {

    private String director;

    private String actor;
}
