package jpabook.start.chmodel.orderitem;

import jpabook.start.chmodel.item.Item;
import jpabook.start.chmodel.orders.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "order_price")
    private Integer orderPrice;

    private Integer count;

    public OrderItem(Integer orderPrice, Integer count) {
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public void setOrder(Order order) {
        if (this.order != null) {
            this.order.getOrderItems().remove(this);
        }
        this.order = order;
        this.order.getOrderItems().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
