package jpabook.jpashop.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

    public Album(String name, Integer price, Integer stockQuantity, String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
