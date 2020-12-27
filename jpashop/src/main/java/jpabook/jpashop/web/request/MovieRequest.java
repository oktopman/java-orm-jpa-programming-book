package jpabook.jpashop.web.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {

    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String director;
    private String actor;

}
