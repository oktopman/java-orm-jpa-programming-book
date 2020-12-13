package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private Set<Order> orders = new HashSet<>();

    @Builder
    public Member(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


}
