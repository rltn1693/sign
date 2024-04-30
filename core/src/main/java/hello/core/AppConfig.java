package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    //생성자 주입
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//    //생성자 주입
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    //저장소의 역할
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();    //메모리 회원 저장소를 사용
    }

    //할인 정책의 역할
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();     //고정 할인 정책을 사용
        return  new RateDiscountPolicy();
    }

    // MemberService 역할 (생성자 주입)
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //OrderService 역할 (생성자 주입0
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
