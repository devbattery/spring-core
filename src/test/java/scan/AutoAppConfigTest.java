package scan;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {

    @DisplayName("")
    @Test
    void basic_scan() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
                AutoAppConfig.class);

        // when
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
