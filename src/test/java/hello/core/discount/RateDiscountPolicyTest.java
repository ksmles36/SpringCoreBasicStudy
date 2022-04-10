package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용되어야 한다.")
    void vipSuccessTest() {
        //given
        Member memberVip = Member.of(1L, "memberVIP", Grade.VIP);

        //when
        int discountAmount = rateDiscountPolicy.getDiscountAmount(memberVip, 15000);

        //then
        assertEquals(discountAmount, 1500);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 X")
    void notVipTest() {
        //given
        Member memberBasic = Member.of(1L, "memberBasic", Grade.BASIC);

        //when
        int discountAmount = rateDiscountPolicy.getDiscountAmount(memberBasic, 15000);

        //then
        assertEquals(discountAmount, 0);
    }

}