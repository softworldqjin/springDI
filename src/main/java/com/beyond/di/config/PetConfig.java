package com.beyond.di.config;

import com.beyond.di.pet.Cat;
import com.beyond.di.pet.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PetConfig {
    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName("멍멍이1");

        return dog;
    }


    @Bean
    @Primary // . Primary 어노테이션을 있는걸 주입해줌
    public Cat cat() {
        return new Cat("애옹이");
    }
}
