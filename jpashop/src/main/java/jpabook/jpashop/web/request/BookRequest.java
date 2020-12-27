package jpabook.jpashop.web.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String author;
    private String isbn;

}
