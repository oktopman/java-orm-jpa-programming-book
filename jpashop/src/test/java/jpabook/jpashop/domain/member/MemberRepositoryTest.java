package jpabook.jpashop.domain.member;

import jdk.nashorn.internal.runtime.options.Option;
import jpabook.jpashop.domain.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("이름으로 유저찾기")
    void findByName_test() {
        //given
        String username = "oktop";
        String name = "이하윤";
        String phone = "010-1221-4121";
        Address address = new Address("seoul", "guro", "15312");
        Member member = new Member(username, name, phone,  address);
        memberRepository.save(member);

        //when
        Optional<Member> optMember = memberRepository.findByUsername(username);

        //then
        assertThat(optMember.get().getUsername()).isEqualTo(username);
    }

}