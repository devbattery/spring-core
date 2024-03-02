package hello.core.xml;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class XmlAppContext {

    @DisplayName("AppConfig와 같이 xml 파일로도 빈을 조회할 수 있다.")
    @Test
    void xml_app_context() {
        // given
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        // when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
