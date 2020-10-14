package jpabook.start.domainrelationshipexample.Team;

import jpabook.start.domainrelationshipexample.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") // mappedBy 속성을 이용하여 연관관계의 주인을 가리켜야 한다. 연관관계의 주인인 Member.team이 MappedBy 속성의
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

}
