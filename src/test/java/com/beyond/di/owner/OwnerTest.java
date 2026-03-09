package com.beyond.di.owner;

import com.beyond.di.pet.Cat;
import com.beyond.di.pet.Dog;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Owner 클래스 테스트")
class OwnerTest {

    // tdd
    @Test
    @Disabled // 다음테스트부터 제외됨
    @DisplayName("실행 환경 테스트")
    void nothing() {
    }
    @Test
    @DisplayName("Owner 객체 생성 테스트")
    void create() {
//        // 생성자를 통한 의존성 주입
        Owner owner = new Owner("홍길동", 34, new Cat("고양이"));
        // 메소드를 통한 의존성 주입
//        Owner owner = new Owner();
        owner.setName("이몽룡");
        owner.setAge(24);
        owner.setCat(new Cat("고양이2"));

        System.out.println(owner);

        assertThat(owner).isNotNull();
        assertThat(owner.getCat()).isNotNull();

    }


}