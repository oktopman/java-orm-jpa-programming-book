package jpabook.jpashop.service;

import jpabook.jpashop.domain.delivery.Delivery;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.ItemRepository;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberRepository;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.order.OrderRepository;
import jpabook.jpashop.domain.orderitem.OrderItem;
import jpabook.jpashop.domain.orderitem.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jpabook.jpashop.domain.order.Order.createOrder;

@Transactional
@Service
public class OrderService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder() {
        //given
        long memberId = 1;
        Member member = memberRepository.findById(memberId)
                .orElseThrow(EntityNotFoundException::new);
        List<Long> itemPks = Arrays.asList(1L, 2L);
        List<Item> list = itemRepository.findByIdIn(itemPks);
        int count = 2;
        List<OrderItem> orderItems = new ArrayList<>();
        list.forEach(e -> {
            OrderItem orderItem = new OrderItem();
            orderItem.createOrderItem(e, e.getPrice(), count);
            orderItems.add(orderItem);
        });
        Delivery delivery = new Delivery(member.getAddress());
        Order order = createOrder(member, delivery, orderItems);
        orderRepository.save(order);
    }
}
