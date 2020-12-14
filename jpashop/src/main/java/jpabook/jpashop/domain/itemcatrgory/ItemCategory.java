package jpabook.jpashop.domain.itemcatrgory;

import jpabook.jpashop.domain.category.Category;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "item_category")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
