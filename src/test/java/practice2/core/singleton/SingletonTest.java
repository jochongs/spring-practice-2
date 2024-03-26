package practice2.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice2.core.AppConfig;
import practice2.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("Innocence DI container without spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        MemberService memberService1 = appConfig.memberService();

        // 둘이 다른 인스턴스를 return함
        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }

    @Test
    @DisplayName("create Singleton Service instance")
    void createSingleTonServiceInstance() {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService1 = SingletonService.getInstance();

        System.out.println("singletonService = " + singletonService);
        System.out.println("singletonService1 = " + singletonService1);

        Assertions.assertThat(singletonService).isSameAs(singletonService1);
    }
}
