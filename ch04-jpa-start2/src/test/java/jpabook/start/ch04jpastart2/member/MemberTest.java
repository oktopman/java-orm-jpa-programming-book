package jpabook.start.ch04jpastart2.member;

import jpabook.start.ch04jpastart2.type.RoleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("member 생성 테스트")
    void member_create_test() {
        //given
        Member member = new Member(
                "colaws3", "leehayun", 31, RoleType.USER, new Date(), new Date(), "description");
        //when
        Member memberEntity = memberRepository.save(member);
        //then
        assertThat(memberEntity.getUsername()).isEqualTo("leehayun");
    }

}