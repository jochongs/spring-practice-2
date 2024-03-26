package practice2.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice2.core.AppConfig;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemberServiceImpl;
import practice2.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        Assertions.assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
        Assertions.assertThat(memberRepository).isSameAs(memberService.getMemberRepository());

        System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());
        System.out.println("orderService.getMemberRepository() = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
    }
}
