package com.study.springcore;

import com.study.springcore.discount.DiscountPolicy;
import com.study.springcore.discount.FixDiscountPolicy;
import com.study.springcore.discount.RateDiscountPolicy;
import com.study.springcore.member.MemberService;
import com.study.springcore.member.MemberServiceImpl;
import com.study.springcore.member.MemoryMemberRepository;
import com.study.springcore.order.OrderService;
import com.study.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
