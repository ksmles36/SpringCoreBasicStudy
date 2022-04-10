package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrderTest() {
        Long memberId = 1L;
        Member memberA = Member.of(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order orderA = orderService.createOrder(memberId, "itemA", 10000);
        int calculatePrice = orderA.calculatePrice();

        Assertions.assertEquals(calculatePrice, 9000);
    }

}
