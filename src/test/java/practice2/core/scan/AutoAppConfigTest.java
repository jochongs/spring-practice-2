package practice2.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice2.core.AutoAppConfig;
import practice2.core.member.MemberRepository;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        MemberRepository memberRepository = ac.getBean( MemberRepository.class);

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }
}
