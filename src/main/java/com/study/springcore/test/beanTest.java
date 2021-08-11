package com.study.springcore.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class beanTest {

    private final PrototypeBean prototypeBean;

}
