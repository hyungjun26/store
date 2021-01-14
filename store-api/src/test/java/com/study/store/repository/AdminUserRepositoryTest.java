package com.study.store.repository;

import com.study.store.component.LoginUserAuditorAware;
import com.study.store.config.JpaConfig;
import com.study.store.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("AdminUser Repository 테스트")
@Import({JpaConfig.class, LoginUserAuditorAware.class})
class AdminUserRepositoryTest {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    @Rollback(value = false)
    public void create(){
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("Admin03");
        adminUser.setPassword("1234");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
        //adminUser.setCreatedAt(LocalDateTime.now());
        //adminUser.setCreatedBy("Server");
        //System.out.println(adminUser.getCreatedAt());
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assertions.assertNotNull(newAdminUser);
    }
}