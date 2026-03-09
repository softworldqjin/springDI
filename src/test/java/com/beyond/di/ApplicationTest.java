package com.beyond.di;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ApplicationTest {

    @Test
    public void nothing() {
        // 이 테스트를 통해서 현재 프로젝트가 테스트가 가능한 환경인지 확인한다
        String name = "홍길동";

        Assertions.assertThat(name).isEqualTo("이몽룡");
    }


}
