package practice2.core;

import practice2.core.member.Grade;
import practice2.core.member.Member;
import practice2.core.member.MemberService;
import practice2.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();

        Member member = new Member(1L, "Jochong", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("member1 = " + member1.getName());
        System.out.println("member = " + member.getName());
    }
}
