package jpabook.jpashop.domain.member;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberStatusType status = MemberStatusType.USE;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String username, String name, String phone, Address address) {
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void pauseMember() {
        this.status = MemberStatusType.PAUSE;
    }

}
