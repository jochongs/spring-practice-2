package practice2.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;

public class OrderServiceTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    void createVipMemberOrder() {
        // given
        Member member = new Member(1L, "jochong", Grade.VIP);
        memberService.join(member);

        int itemPrice = 10000;
        Order createdOrder = orderService.createOrder(member.getId(), "itemA", itemPrice);

        int discountPrice = createdOrder.discountPrice();

        // then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
        Assertions.assertThat(createdOrder.calculatePrice()).isEqualTo(itemPrice - discountPrice);
    }

    @Test
    void createMemberOrder() {
        // given
        Member member = new Member(1L, "jochong2", Grade.BASIC);
        memberService.join(member);

        int itemPrice = 10000;
        Order createdOrder = orderService.createOrder(member.getId(), "itemB", itemPrice);

        int discountPrice = createdOrder.discountPrice();

        // then
        Assertions.assertThat(discountPrice).isEqualTo(0);
        Assertions.assertThat(createdOrder.calculatePrice()).isEqualTo(itemPrice - discountPrice);
    }
}
