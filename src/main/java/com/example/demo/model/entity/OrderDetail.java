package com.example.demo.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity // order_detail에 자동으로 연결됨 (db의 snake_case 자동으로 변경)
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"user", "item"})
@ToString(exclude = {"orderGroup", "item"})
@Builder
@Accessors(chain = true)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    //    private Long itemId;
    // OrderDetail N : 1 Item (각 아이템마다 여러 주문건이 있을 수 있음)
    @ManyToOne
    private Item item;

    //    private Long orderGroupId;
    // OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;

//    // N:1 orderDetail의 입장에서 생각했을 때 user는 N:1임.
//    @ManyToOne
//    private User user; //userId로 하는 것이 아니라 user로 설정해주어야 함. (객체의 이름을 적어주면 알아서 userId를 찾아감)
//
//    @ManyToOne
//    private Item item;

}
