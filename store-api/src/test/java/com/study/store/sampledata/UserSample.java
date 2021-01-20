package com.study.store.sampledata;

import com.study.store.component.LoginUserAuditorAware;
import com.study.store.config.JpaConfig;
import com.study.store.model.entity.User;
import com.study.store.model.enumclass.UserStatus;
import com.study.store.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({JpaConfig.class, LoginUserAuditorAware.class})
public class UserSample {
    private Random random;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void sampleCreate(){

        random = new Random();

        for(int i = 1 ; i < 1001; i++){
            // 가입 상태 랜덤
            int div = (random.nextInt(10)+1) % 2;
            UserStatus status = (div == 0 ? UserStatus.REGISTERED : UserStatus.UNREGISTERED);

            User user = User.builder()
                    .account("account"+i)
                    .password("password"+i)
                    .status(status)
                    .email("account"+i+"@gmail.com")
                    .phoneNumber("010-1111-"+String.format("%04d", i))
                    .registeredAt(getRandomDate())
                    .unregisteredAt(status.equals(UserStatus.UNREGISTERED) ? getRandomDate() : null )
                    .build();

            //log.info("{}",user);
            userRepository.save(user);
        }


    }


    private LocalDateTime getRandomDate(){
        return LocalDateTime.of(2021,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
