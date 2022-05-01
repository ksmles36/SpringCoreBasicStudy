package hello.core.scan;

import hello.core.member.MemberService;
import hello.core.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberServiceBean = ac.getBean(MemberService.class);
        assertThat(memberServiceBean).isInstanceOf(MemberService.class);
    }

}
