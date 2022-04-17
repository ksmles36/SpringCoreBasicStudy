package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();


        Long memberId = 1L;
        Member memberA = Member.of(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order orderA = orderService.createOrder(memberId, "itemA", 20000);
        int calculatePrice = orderA.calculatePrice();

        System.out.println("orderA = " + orderA);
        System.out.println("calculatePrice = " + calculatePrice);
    }

}
