package com.study.store.sampledata;

import com.study.store.component.LoginUserAuditorAware;
import com.study.store.config.JpaConfig;
import com.study.store.model.entity.Category;
import com.study.store.model.entity.Partner;
import com.study.store.repository.CategoryRepository;
import com.study.store.repository.PartnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({JpaConfig.class, LoginUserAuditorAware.class})
public class PartnerSample {
    private Random random;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Rollback(value = false)
    public void sampleCreate(){
        random = new Random();
        List<Category> categoryList = categoryRepository.findAll();

        for(int i = 0; i < categoryList.size(); i++){
            Category category = categoryList.get(i);

            for(int j = 1; j < 10; j++){

                // 가입 상태 랜덤
                int div = (random.nextInt(10)+1) % 2;
                String status = (div == 0 ? "REGISTERED" : "UNREGISTERED");

                Partner partner = Partner.builder()
                        .category(category)
                        .name(category.getTitle()+j+" 호점")
                        .status(status)
                        .address("서울시 강남구 "+j+"번길"+random.nextInt(100)+1+"호")
                        .callCenter("070-"+String.format("%04d", random.nextInt(100)+1)+"-"+String.format("%04d", random.nextInt(100)+1))
                        .partnerNumber("010-1111-"+String.format("%04d", i))
                        .businessNumber((random.nextInt(999999999)+1)+""+j)
                        .ceoName(j+" 대표")
                        .registeredAt(getRandomDate())
                        .unregisteredAt(status.equals("UNREGISTERED") ? getRandomDate() : null )
                        .build();
                //log.info("{}",partner);
                partnerRepository.save(partner);
            }
        }
    }


    private LocalDateTime getRandomDate(){
        return LocalDateTime.of(2021,getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber(),getRandomNumber());
    }

    private int getRandomNumber(){
        return random.nextInt(11)+1;
    }
}
