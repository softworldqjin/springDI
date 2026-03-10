package com.beyond.di.weapon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Primary
@Component("WindForce") // Bean ID 이걸로 등록가능, 클래스명이 아니라.
public class Bow extends Weapon {
    // application context에 String타입 객체(빈)이 없어서 직접 주입
    public Bow(@Value("활1") String name) {
        super(name);
    }

    @Override
    public String attack() {
        return "활을 쏜다";
    }

    @Override
    public String toString() {
        return "Bow{" +
                "name='" + name + '\'' +
                '}';
    }
}
