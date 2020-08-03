package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    // private UserRepository userRepository = new UserRepository();
    // 어플리케이션이 실행될 때 Autowired 어노테이션이 붙은애들은 알아서 생성해줌.
    // DI(Dependency Injection)

    @Test
    public void create(){
        User user = new User();
//        user.setId(); //id값은 AutoIn
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user); // 레포지토리에도 id도 추가해서 자동으로 생성됨.
        System.out.println("newUser : " + newUser);
    }

    public void read(){

    }

    public void update(){

    }

    public void remove(){

    }
}
