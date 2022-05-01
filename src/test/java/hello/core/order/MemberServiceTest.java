package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member1 = new Member(1L,"member1", Grade.VIP);

        //when
        memberService.join(member1);
        Member findMember = memberService.findMember(member1.getId());

        //then
        Assertions.assertThat(member1).isEqualTo(findMember);
    }
}
