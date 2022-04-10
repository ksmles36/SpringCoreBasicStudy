package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member memberA = Member.of(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order orderA = orderService.createOrder(memberId, "itemA", 10000);
        int calculatePrice = orderA.calculatePrice();

        System.out.println("orderA = " + orderA);
        System.out.println("calculatePrice = " + calculatePrice);
    }

}
