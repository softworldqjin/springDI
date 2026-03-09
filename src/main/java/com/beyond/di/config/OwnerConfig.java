package com.beyond.di.config;

import com.beyond.di.owner.Owner;
import com.beyond.di.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OwnerConfig {
    @Bean("hong")
    // 빈을 생성할 때 application context에 빈 있으면
    // 메소드에 해당 빈 넣어주세요

    // dog라는 아이디를 주입해줘
    public Owner owner(@Autowired @Qualifier("dog") Pet pet) {
        Owner owner = new Owner();
        owner.setAge(22);
        owner.setName("홍길동");
        owner.setPet(pet);
        return owner;
    }

    @Bean
    // Pet pet 변수는 무조건 주입된다. Autowired 생략
    // Pet타입 빈 주입하려는데, Qualifier없음, 빈이 두 개이상인데요 -> error 발생
    // -> 해결법: Pet타입 빈 중에 Primary 어노테이션 있는걸 주입해줌
    public Owner lee(/*@Autowired */ Pet pet) {
        return new Owner("이몽룡",24, pet);
    }
}
