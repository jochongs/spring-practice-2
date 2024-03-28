package practice2.core.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import practice2.core.member.Member;
import practice2.core.member.MemberRepository;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // 의존 관계가 없으면 호출자체가 되지 않음
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        // Nullable 하면 호출은 가능하되 Null로 넣어줌
        @Autowired(required = true)
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);
        }

        // Optional.empty로 데이터를 넣어줌
        @Autowired(required = true)
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
