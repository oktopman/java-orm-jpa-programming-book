package jpabook.jpashop.web.request;

import com.sun.istack.NotNull;
import jpabook.jpashop.domain.Address;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    @NotNull
    private Address address;

}
