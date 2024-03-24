package practice2.core;

import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.order.Order;
import practice2.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "Jochong", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(member.getId(), "itemA", 10000);
        System.out.println(itemA.toString());
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());
    }
}
