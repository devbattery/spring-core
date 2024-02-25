package hello.core.bean_find;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("모든 빈을 출력할 수 있다.")
    @Test
    void find_all_bean() {
        // given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        // when
        // then
        for (String name : beanDefinitionNames) {
            Object bean = ac.getBean(name);
            System.out.println("name = " + name + ", object = " + bean);
        }
    }

    @DisplayName("애플리케이션 빈을 출력할 수 있다.")
    @Test
    void find_application_bean() {
        // given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        // when
        // then
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(name);
                System.out.println("name = " + name + ", object = " + bean);
            }
        }
    }

}
