package hello.core.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();

    @DisplayName("member와 찾은 member가 같다.")
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }

}
