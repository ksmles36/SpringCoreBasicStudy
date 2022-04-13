package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
