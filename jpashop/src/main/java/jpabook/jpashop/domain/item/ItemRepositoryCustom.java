package jpabook.jpashop.domain.item;

import jpabook.jpashop.web.response.ItemResponse;

import java.util.List;

public interface ItemRepositoryCustom {

    List<ItemResponse> searchIn(List<Long> condition);
}
