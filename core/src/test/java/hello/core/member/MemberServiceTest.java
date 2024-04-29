package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(1L, "memberB", Grade.VIP);

        memberService.join(memberA);
        memberService.join(memberB);

        Member findmemberA = memberService.findMember(1L);
        Member findmemberB = memberService.findMember(2L);

        Assertions.assertThat(memberA).isEqualTo(findmemberA);
        Assertions.assertThat(memberA).isEqualTo(findmemberB);

    }

    @Test
    void findMember() {
    }
}