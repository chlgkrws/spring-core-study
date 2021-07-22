package com.study.springcore.order;

import com.study.springcore.discount.DiscountPolicy;
import com.study.springcore.discount.FixDiscountPolicy;
import com.study.springcore.discount.RateDiscountPolicy;
import com.study.springcore.member.Member;
import com.study.springcore.member.MemberRepository;
import com.study.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}