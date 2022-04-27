package hello.core;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(1L, "member1", Grade.VIP);

        memberService.join(member1);

        Member findMember = memberService.findMember(member1.getId());
        System.out.println("New Member : " + member1.getName());
        System.out.println("Find Member : " + findMember.getName());
    }
}
