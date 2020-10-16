package jpabook.start.chmodel.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@DiscriminatorValue("album")
@Table(name = "album")
public class Album extends Item {

    private String artist;

    private String etc;

}
