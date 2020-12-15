package jpabook.jpashop.domain.member;

import jpabook.jpashop.domain.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("이름으로 유저찾기")
    void findByName_test() {
        //given
        String name = "이하윤";
        String phone = "010-1221-4121";
        Address address = new Address("seoul", "guro", "15312");
        Member member = new Member(name, phone,  address);
        memberRepository.save(member);

        //when
        List<Member> members = memberRepository.findByName(name);

        //then
        assertThat(members.size()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo("이하윤");
    }

}