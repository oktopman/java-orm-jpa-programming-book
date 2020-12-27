package jpabook.jpashop.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);
    List<Item> findByIdIn(List<Long> ids);
}
