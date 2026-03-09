package com.beyond.di.config;

import com.beyond.di.owner.Owner;
import com.beyond.di.pet.Cat;
import com.beyond.di.pet.Dog;
import com.beyond.di.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

// 해당 클래스가 자바 설정 파일임을 선언한다.
@Configuration

// OwnerConfig PetConfig class 파일 복붙
@Import(value= {OwnerConfig.class, PetConfig.class})
public class RootConfig {

}
