package hello.core.bean_find;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회할 수 있다.")
    @Test
    void find_bean_by_name() {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // when
        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("이름 없이 타입으로만 조회할 수 있다.")
    @Test
    void find_bean_by_type() {
        // given
        MemberService memberService = ac.getBean(MemberService.class);

        // when
        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /**
     * 구현에 의존하는 코드기 때문에 좋은 코드는 아님
     */
    @DisplayName("구현체 타입으로 조회할 수 있다.")
    @Test
    void find_bean_by_impl_type() {
        // given
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // when
        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("빈 이름으로 조회할 수 없다.")
    @Test
    void find_bean_by_name_failed() {
        // given
        // when
        // then
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }

}
