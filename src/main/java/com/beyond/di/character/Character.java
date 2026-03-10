package com.beyond.di.character;

import com.beyond.di.weapon.Weapon;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component
public class Character {
    @Value("홍길동")
    private String name;

    @Value("77")
    private int level;

    @Autowired // application context에 있는 빈을 주입
    // Weapon 타입의 빈이 여러개 있으면 뭘 주입할지 판단 못함 -> error
    // 해결법: 특정 클래스에 Primary 어노테이션 붙이면됨
    // 또는 @Qualifier("sword")
    private Weapon weapon;
}
