package jpabook.jpashop.domain.member;

import lombok.Getter;

@Getter
public enum MemberStatusType {

    USE("use"),
    PAUSE("pause"),
    DELETE("delete");

    private String value;

    MemberStatusType(String value) {
        this.value = value;
    }
}
