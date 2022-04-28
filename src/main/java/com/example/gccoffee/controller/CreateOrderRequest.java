package com.example.gccoffee.controller;

import com.example.gccoffee.model.OrderItem;

import java.util.List;

public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {
    // TODO : RECORD 사용이유
    // JSON으로 표현하기 위한 데이터 정의 가능, 타입 정의 가능
    // 예시 -> email은 Email 객체에 담아야하는데, String에 담아서 Service단으로 보낸다.
    // 다른 메시지 포맷으로 변환되기 위한 필요한 기능을 구현가능
    // 그걸 서비스가 아닌 여기서 처리하는게 서비스의 역할에 더 맞다.
}
