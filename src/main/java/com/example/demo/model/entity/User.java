package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Table(name = "user") //table의 이름과 동일하므로 선언하지 않아도 됨.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1: N (user기준에서 orderDetail을 볼 때)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") //OrderDetail에 있는 어떤 변수에 매핑시킬 것인가?
    private List<OrderDetail> orderDetailList;

}
