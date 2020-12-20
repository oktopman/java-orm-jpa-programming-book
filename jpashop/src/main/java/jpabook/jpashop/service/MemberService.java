package jpabook.jpashop.service;

import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberRepository;
import jpabook.jpashop.web.request.MemberRequest;
import jpabook.jpashop.web.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static jpabook.jpashop.web.response.MemberResponse.entityToResponse;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(MemberRequest request) {
        validationDuplicateMember(request.getUsername());
        Member member = Member.builder()
                .username(request.getUsername())
                .name(request.getName())
                .phone(request.getPhone())
                .address(request.getAddress()).build();
        memberRepository.save(member);
    }

    public void validationDuplicateMember(final String username) {
        Optional<Member> findMember = memberRepository.findByUsername(username);
        if (findMember.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }

    public MemberResponse getMember(final Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(EntityNotFoundException::new);
        return entityToResponse(member);
    }

    public void pauseMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        member.pauseMember();
    }
}
