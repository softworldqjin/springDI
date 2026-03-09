package com.beyond.di.owner;

import com.beyond.di.config.RootConfig;
import com.beyond.di.pet.Cat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

// JUnit에서 스프링을 사용할 수 있도록 SpringExtension.class 사용하여 확장한다
@ExtendWith(SpringExtension.class)
// @ContextConfiguration을 통해서 설정 파일을 읽고 애플리케이션 컨텍스트를 생성한다
@ContextConfiguration(locations = "classpath:spring/root-context.xml")
//@ContextConfiguration(classes = RootConfig.class)
@DisplayName("Owner 클래스 테스트")
class OwnerTest {
    @Autowired
    @Qualifier("lee")
    // 자동 주입해줘 Owner타입
    private Owner owner;


    @Test
    @DisplayName("GenericXmlApplicationContext")
    void genericXmlApplicationContext() {
        // 기본적으로 클래스 패스를 기준으로 파일을 찾는다.
        // 해당 위치에 있는 xml에서 빈(객체) 만들어주세요
        ApplicationContext context =
//                new GenericXmlApplicationContext("spring/root-context.xml");
                new GenericXmlApplicationContext("classpath:spring/root-context.xml");
//                new GenericXmlApplicationContext("file:src/main/resources/spring/root-context.xml");

        // 나중에 AutoWired할 부분
        // 만든 빈(객체).getBean 해당주소 중에 name이 lee인 객체 가져올게여
        Owner owner = (Owner) context.getBean("hong");
//        Owner hong = context.getBean("hong", Owner.class);
        System.out.println(owner);
        assertThat(context).isNotNull();
        assertThat(owner).isNotNull();
        assertThat(owner.getPet()).isNotNull();

    }
//    // tdd
//    @Test
//    @Disabled // 다음테스트부터 제외됨
//    @DisplayName("실행 환경 테스트")
//    void nothing() {
//    }
    @Test
    @DisplayName("Owner 객체 생성 테스트")
    void create() {
        // 기존에 자바 애플리케이션에서는 다형성을 통해서 객체 간의 결합도를 느슨하게 만들어준다.
//        // 생성자를 통한 의존성 주입
        Owner owner = new Owner("홍길동", 34, new Cat("고양이"));
        // 메소드를 통한 의존성 주입
//        Owner owner = new Owner();
        owner.setName("이몽룡");
        owner.setAge(24);
        owner.setPet(new Cat("고양이2"));

        System.out.println(owner);

        assertThat(owner).isNotNull();
        assertThat(owner.getPet()).isNotNull();

    }

    @Test
    @DisplayName("annotationConfigApplicationContext")
    void name() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(RootConfig.class); // 자바 설정을 받아서 빈의 의존성?설정

        // 이 Bean을 Owner 타입으로 가져와라
        Owner owner = context.getBean("lee", Owner.class);
        System.out.println(owner);

        assertThat(owner).isNotNull();
        assertThat(context).isNotNull();
        assertThat(owner.getPet()).isNotNull();

    }

    @Test
    @DisplayName("Autowired 테스트")
    void autowiredTest() {
        System.out.println(owner);

        assertThat(owner).isNotNull();
        assertThat(owner.getPet()).isNotNull();
    }

}