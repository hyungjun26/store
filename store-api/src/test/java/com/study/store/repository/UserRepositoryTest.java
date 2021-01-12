package com.study.store.repository;

import com.study.store.model.entity.Item;
import com.study.store.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("UserRepositoryTest")
public class UserRepositoryTest {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void create(){
        User user = new User();

        user.setAccount("User01");
        user.setPassword("1234");
        user.setEmail("User01@gmail.com");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findByAccount("User01");

        user.ifPresent(selectUser->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    @Rollback(value = false)
    public void update(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser->{
            selectUser.setAccount("Update01");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Rollback(value = false)
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(1L);
//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재함 : " + deleteUser.get());
//        } else {
//            System.out.println("데이터가 존재하지 않음");
//        }
        Assertions.assertFalse(deleteUser.isPresent());
    }
}
