package jpabook.jpashop.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Entity
@Table(name = "item")
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    public Item(String name, Integer price, Integer stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

//    @OneToMany(mappedBy = "item")
//    private List<ItemCategory> itemCategories = new ArrayList<>();
}
