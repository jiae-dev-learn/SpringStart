package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //가장 처음 휴대폰 번호가 매칭되는 아이디를 반환
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

//                                    // 엔티티 이름, primary 키 형식
//
//    // select * from user where account = ? 와 같은 의미
//    Optional<User> findByAccount(String account);
//
//    Optional<User> findByEmail(String email);
//
//    // 여러개 동시에 검색할 경우는 아래와 같이 사용
//    // select * from user where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);
}
