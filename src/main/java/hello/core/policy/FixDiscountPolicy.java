package hello.core.policy;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return 1000;
        return 0;
    }
}
