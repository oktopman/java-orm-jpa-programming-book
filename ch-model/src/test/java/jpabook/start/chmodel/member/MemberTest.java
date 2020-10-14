package jpabook.start.chmodel.member;

import jpabook.start.chmodel.item.Item;
import jpabook.start.chmodel.item.ItemRepository;
import jpabook.start.chmodel.orderitem.OrderItem;
import jpabook.start.chmodel.orderitem.OrderItemRepository;
import jpabook.start.chmodel.orders.Order;
import jpabook.start.chmodel.orders.OrderRepository;
import jpabook.start.chmodel.orders.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void entity_save_test() {
        //member
        Member member = new Member("leehayun", "seoul", "64-28");
        Member memberEntity = memberRepository.save(member);

        //item
        Item item = new Item("돌김", 4000, 2);
        Item item2 = new Item("아이스크림", 6000, 1);
        List<Item> items = itemRepository.saveAll(Arrays.asList(item, item2));

        //order
        Order order = new Order(LocalDate.now(), OrderStatus.ORDER);
        order.setMember(member);

        OrderItem orderItem = new OrderItem(8000, 2);
        orderItem.setOrder(order);
        orderItem.setItem(item);

        OrderItem orderItem2 = new OrderItem(6000, 1);
        orderItem2.setOrder(order);
        orderItem2.setItem(item2);
        Order orderEntity = orderRepository.save(order);
        List<OrderItem> orderItems = orderItemRepository.saveAll(Arrays.asList(orderItem, orderItem2));

    }




}