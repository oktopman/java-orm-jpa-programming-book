package jpabook.jpashop.domain.member;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.order.Order;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


}
