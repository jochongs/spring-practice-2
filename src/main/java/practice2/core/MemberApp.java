package practice2.core;

import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "Jochong", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("member1 = " + member1.getName());
        System.out.println("member = " + member.getName());
    }
}
