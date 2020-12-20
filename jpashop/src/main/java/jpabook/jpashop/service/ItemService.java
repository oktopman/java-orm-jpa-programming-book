package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final BookRepository itemRepository;

    //todo 상품추가
    //todo 상품 재고 늘리기
    // todo 상품 재고 삭제

}
