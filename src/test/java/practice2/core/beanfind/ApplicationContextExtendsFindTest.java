package practice2.core.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice2.core.AppConfig;
import practice2.core.discount.DiscountPolicy;
import practice2.core.discount.FixDisountPolicy;
import practice2.core.discount.RateDiscountPolicy;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("Get beans by parent class type")
    void findBeanByParentTypeDuplicate() {
        Assertions.assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class)
        );
    }

    @Test
    @DisplayName("Get bean by bean name")
    void findBeanByparentTypeBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    @DisplayName("Find bean by specific low level class type")
    void findBeanBySpecificLowLevelType() {
        RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);

        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDisountPolicy() {
            return new FixDisountPolicy();
        }
    }
}
