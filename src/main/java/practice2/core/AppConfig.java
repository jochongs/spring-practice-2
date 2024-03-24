package practice2.core;

import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.RateDiscountPolicy;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.member.MemoryMemberRepository;
import practice2.core.order.OrderService;
import practice2.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
