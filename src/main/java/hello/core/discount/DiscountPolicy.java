package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * 대상 회원 할인 금액
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
