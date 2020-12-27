package jpabook.jpashop.web.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {

    private String name;
    private Integer price;
    private Integer stockQuantity;
}
