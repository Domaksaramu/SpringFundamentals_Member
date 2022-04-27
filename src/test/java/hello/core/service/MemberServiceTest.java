package hello.core.service;

import hello.core.domain.Grade;
import hello.core.domain.Member;
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
