package jpabook.start.domainrelationshipexample.member;

import jpabook.start.domainrelationshipexample.Team.Team;
import jpabook.start.domainrelationshipexample.Team.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Transactional
    @Test
    void member_relationship_team_select_test() {
        //given
        Team team = new Team("team");
        Team team2 = new Team("team2");
        teamRepository.saveAll(Arrays.asList(team, team2));

        Member member = new Member("leehayun");
        member.setTeam(team);
        memberRepository.save(member);
        //when
        Member memberEntity = memberRepository.findByName("leehayun");
        //then
        assertThat(memberEntity.getTeam().getName()).isEqualTo("team");
    }

    @Transactional
    @Test
    void member_relationship_team_save_test() {
        //given, when
        Team team1 = new Team("team1");
        teamRepository.save(team1);

        Member member1 = new Member("leehayun");
        member1.setTeam(team1);
        Member member1Entity = memberRepository.save(member1);

        Member member2 = new Member("leehayun2");
        member2.setTeam(team1);
        Member member2Entity = memberRepository.save(member2);

        assertThat(member1Entity.getTeam().getName()).isEqualTo("team1");
        assertThat(member2Entity.getTeam().getName()).isEqualTo("team1");
    }

    @Transactional
    @Test
    void member_relationship_set_team_test() {
        //given
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
//        teamRepository.saveAll(Arrays.asList(team1, team2));

        Member member1 = new Member("leehayun");
        member1.setTeam(team1);
        member1.setTeam(team2);
        //when
        List<Member> members = team1.getMembers();
        //then
        assertThat(members.size()).isEqualTo(0);
    }

}