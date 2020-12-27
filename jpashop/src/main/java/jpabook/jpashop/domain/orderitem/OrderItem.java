package jpabook.jpashop.domain.orderitem;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer orderPrice; // 주문가격

    private Integer count; // 주문수량

    public void setOrder(Order order) {
        this.order = order;
    }

    public void createOrderItem(Item item, int orderPrice, int count) {
        this.setItem(item);
        this.setOrderPrice(orderPrice);
        this.setCount(count);
        item.removeStock(count);
    }
}
