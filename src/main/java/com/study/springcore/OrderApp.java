package com.study.springcore;

import com.study.springcore.member.Grade;
import com.study.springcore.member.Member;
import com.study.springcore.member.MemberService;
import com.study.springcore.member.MemberServiceImpl;
import com.study.springcore.order.Order;
import com.study.springcore.order.OrderService;
import com.study.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
