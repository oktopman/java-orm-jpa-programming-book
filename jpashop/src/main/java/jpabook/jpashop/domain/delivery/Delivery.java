package jpabook.jpashop.domain.delivery;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.order.Order;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "delivery")
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrder(Order order) {
        this.order = order;
    }

}
