package jpabook.start.chmodel.member;

import jpabook.start.chmodel.BaseEntity;
import jpabook.start.chmodel.orders.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member(String name, String city, String zipCode) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
    }

}
