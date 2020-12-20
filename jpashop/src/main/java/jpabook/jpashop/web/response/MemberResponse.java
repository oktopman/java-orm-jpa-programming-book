package jpabook.jpashop.web.response;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.domain.member.MemberStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberResponse {

    private Long id;
    private String username;
    private String name;
    private String phone;
    private Address address;
    private String status;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    public static MemberResponse entityToResponse(Member member) {
        MemberResponse response = new MemberResponse();
        BeanUtils.copyProperties(member, response);
        response.status = member.getStatus().getValue();
        return response;
    }

}
