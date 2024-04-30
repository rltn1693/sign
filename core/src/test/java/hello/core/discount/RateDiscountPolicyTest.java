package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //회원 생성 및 저장
    MemberService memberService;

    //정률 할인 정책
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void discount(){

        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member memberB = new Member(2L, "memberB", Grade.Basic);
        memberService.join(memberB);

        //when
        int discountA = discountPolicy.discount(memberA, 20000);
        int discountB = discountPolicy.discount(memberB, 10000);

        //then
        Assertions.assertThat(discountA).isEqualTo(2000);
        Assertions.assertThat(discountB).isEqualTo(0);


    }

}