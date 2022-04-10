package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member memberA = Member.of(1L, "memberA", Grade.VIP);

        //when
        memberService.join(memberA);
        Member findMemberA = memberService.findMember(memberA.getId());

        //then
        Assertions.assertEquals(memberA, findMemberA);
    }

}
