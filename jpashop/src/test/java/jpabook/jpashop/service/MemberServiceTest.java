package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberRepository;
import jpabook.jpashop.web.request.MemberRequest;
import jpabook.jpashop.web.response.MemberResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void join_member() {
        //given
        Address address = new Address("seoul", "guro", "64-28");
        MemberRequest request = new MemberRequest("oktop", "hayun", "010-1234-5555", address);
        //when
        memberService.join(request);
    }

    @Transactional
    @Test
    void getMember() {
        //given
        Address address = new Address("seoul", "guro", "64-28");
        Member member = new Member("testUserName", "name", "010-9999-0000", address);
        Member saveMember = memberRepository.save(member);
        //when
        MemberResponse response = memberService.getMember(saveMember.getId());
        //then
        assertThat(response).isNotNull();
        assertThat(response.getUsername()).isEqualTo("testUserName");
        assertThat(response.getName()).isEqualTo("name");
        assertThat(response.getStatus()).isEqualTo("use");
    }

    @Transactional
    @Test
    void pause_member() {
        //given
        Address address = new Address("seoul", "guro", "64-28");
        Member member = new Member("testUserName", "name", "010-9999-0000", address);
        Member saveMember = memberRepository.save(member);
        //when
        memberService.pauseMember(saveMember.getId());

        assertThat(saveMember.getStatus().getValue()).isEqualTo("pause");
    }

}