package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends DemoApplicationTests {

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

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByAccount("TestUser01");

        user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L); //TODO: 아이디를 받아오기
        user.ifPresent(selectUser->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 데이터를 지우지 않고 테스트 후 롤백해줌
    public void delete(){
        Optional<User> user = userRepository.findById(10L); //TODO: 아이디를 받아오기

        Assert.assertTrue(user.isPresent()); // true

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deletedUser = userRepository.findById(10L); //TODO: 아이디를 받아오기

        Assert.assertFalse(deletedUser.isPresent()); // false

    }
}
