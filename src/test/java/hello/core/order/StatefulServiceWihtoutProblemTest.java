package hello.core.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceWihtoutProblemTest {
    @Test
    @DisplayName("싱글톤 팩토리의 공유 자원로 인한 문제는 지역변수로 해결한다")
    void statefulServiceWihtoutProblemTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulServiceWihtoutProblem service1 = ac.getBean(StatefulServiceWihtoutProblem.class);
        StatefulServiceWihtoutProblem service2 = ac.getBean(StatefulServiceWihtoutProblem.class);
        int resultA = service1.order("ThreadA",10000);
        int resultB = service2.order("ThreadB",20000);


        assertThat(resultA).isNotEqualTo(resultB);
    }
    static class TestConfig{
        @Bean
        StatefulServiceWihtoutProblem statefulServiceWihtoutProblem(){
            return new StatefulServiceWihtoutProblem();
        }
    }
}