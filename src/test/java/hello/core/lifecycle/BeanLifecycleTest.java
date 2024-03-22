package hello.core.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @DisplayName("")
    @Test
    void lifecycle_test() {
        // given
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);

        // when
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

        // then
    }

    @Configuration
    static class LifecycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.dev");
            return networkClient;
        }

    }

}
