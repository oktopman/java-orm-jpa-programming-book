package jpabook.jpashop.web.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumRequest {

    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String artist;
    private String etc;
}
