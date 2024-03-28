package practice2.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.RateDiscountPolicy;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.member.MemoryMemberRepository;
import practice2.core.order.OrderService;
import practice2.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
