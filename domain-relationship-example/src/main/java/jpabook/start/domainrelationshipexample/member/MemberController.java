package jpabook.start.domainrelationshipexample.member;

import jpabook.start.domainrelationshipexample.Team.Team;
import jpabook.start.domainrelationshipexample.Team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostMapping("/save")
    public String save() {
        Team team = new Team("team");
        teamRepository.save(team);

        Member member = new Member("leehayun");
        member.setTeam(team);
        memberRepository.save(member);
        return "200";
    }

    @Transactional
    @PutMapping("update")
    public String update() {
        Team team2 = new Team("team2");
        teamRepository.save(team2);

        Member member = memberRepository.findByName("leehayun");
        member.setTeam(team2);
        return "200";
    }
}
