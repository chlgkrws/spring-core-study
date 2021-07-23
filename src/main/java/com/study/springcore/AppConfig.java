package com.study.springcore;

import com.study.springcore.discount.DiscountPolicy;
import com.study.springcore.discount.FixDiscountPolicy;
import com.study.springcore.discount.RateDiscountPolicy;
import com.study.springcore.member.MemberService;
import com.study.springcore.member.MemberServiceImpl;
import com.study.springcore.member.MemoryMemberRepository;
import com.study.springcore.order.OrderService;
import com.study.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
