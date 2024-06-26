package practice2.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;
import practice2.core.order.Order;
import practice2.core.order.OrderService;
import practice2.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "Jochong", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(member.getId(), "itemA", 12000);
        System.out.println(itemA.toString());
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());
    }
}
