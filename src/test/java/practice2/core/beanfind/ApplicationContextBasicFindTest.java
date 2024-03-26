package practice2.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice2.core.AppConfig;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Find bean by name of bean")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("Find bean by abstract class type")
    void findBeanByAbstractClassType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Find bean by concrete class type")
    void findBeanByConcreteClassType() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Find bean by name but cannot find bean")
    void findBeanByNameButNoBean() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> {
                    ac.getBean("xxxx", MemberService.class);
                });
    }
}
