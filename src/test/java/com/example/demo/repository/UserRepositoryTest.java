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
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedBy(createdBy);
        user.setCreatedAt(createdAt);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assert.assertNotNull(user);
//        Optional<User> user = userRepository.findByAccount("TestUser01");
//
//        user.ifPresent(selectUser->{
//            selectUser.getOrderDetailList().stream().forEach(detail->{
//                Item item = detail.getItem();
//                System.out.println(item);
//            });
//        });
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

        user.ifPresent(selectUser-> {
            userRepository.delete(selectUser);
        });

        Optional<User> deletedUser = userRepository.findById(10L); //TODO: 아이디를 받아오기

        Assert.assertFalse(deletedUser.isPresent()); // false

    }
}
