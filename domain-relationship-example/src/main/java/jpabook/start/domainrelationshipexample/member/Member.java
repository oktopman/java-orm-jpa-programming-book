package jpabook.start.domainrelationshipexample.member;

import jpabook.start.domainrelationshipexample.Team.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id") // 연관관계의 주인
    private Team team;

    public Member(String name) {
        this.name = name;
    }
    public void setTeam(Team team) {
        if (this.team != null) { // 기존에 설정된값이 있다면 remove
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }
}
