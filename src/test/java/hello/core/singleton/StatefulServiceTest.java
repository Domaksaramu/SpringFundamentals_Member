package hello.core.singleton;

import hello.core.order.StatefulService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 팩토리(스프링 빈)의 공유 자원(전역변수)로 인한 주문 문제")
    void StatefulServiceTestSingltonTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("ThreadA",10000);
        statefulService2.order("ThreadB",20000);

        assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
        assertThat(statefulService2.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public  StatefulService statefulService() {
            return new StatefulService();
        }
    }
}