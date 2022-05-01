package hello.core.service;

import hello.core.domain.Member;
import hello.core.domain.Order;
import hello.core.policy.DiscountPolicy;
import hello.core.policy.FixDiscountPolicy;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService
{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, Integer itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
