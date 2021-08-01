package com.study.springcore.order;

import com.study.springcore.discount.FixDiscountPolicy;
import com.study.springcore.member.Grade;
import com.study.springcore.member.Member;
import com.study.springcore.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "ItemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
