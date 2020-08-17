package com.example.demo.model.network.request;

import com.example.demo.model.enumclass.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderGroupApiRequest {
    private Long id;

    private String status;

    private OrderType orderType; //묶음 주문인지 등

    private String revAddress;

    private String revName;

    private String paymentType; //카드 주문인지 등

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;





}
