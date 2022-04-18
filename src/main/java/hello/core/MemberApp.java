package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

        //ApplicationContext 가 컨테이너다, 얘가 Appconfig에 정의해놓은 의존관계용 객체들을 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

//        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberA = Member.of(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member findMember = memberService.findMember(memberA.getId());

        System.out.println("join memberA = " + memberA);
        System.out.println("find Member = " + findMember);

    }

}
