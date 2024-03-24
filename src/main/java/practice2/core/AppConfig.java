package practice2.core;

import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.RateDiscountPolicy;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.member.MemoryMemberRepository;
import practice2.core.order.OrderService;
import practice2.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy()
        );
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
