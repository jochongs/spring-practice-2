package practice2.core.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice2.core.AppConfig;
import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.order.OrderService;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    private AppConfig appConfig;

    private MemberService memberService;
    private DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach() {
        appConfig = new AppConfig();

        memberService = appConfig.memberService();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vipDiscountSuccess() {
        // given
        Member member = new Member(1L, "jochong2", Grade.VIP);
        memberService.join(member);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Basic은 할인이 적용되지 않는다.")
    void basicDiscountSuccess() {
        // given
        Member member = new Member(1L, "jochongBasic", Grade.BASIC);
        memberService.join(member);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}