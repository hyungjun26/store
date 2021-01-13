package com.study.store.repository;

import com.study.store.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("OrderDetailRepositoryTest")
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    @Rollback(value = false)
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

       orderDetail.setStatus("WAITING");
       orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
       orderDetail.setQuantity(1);
       orderDetail.setTotalPrice(BigDecimal.valueOf(970000));
       orderDetail.setOrderGroupId(1L);
       orderDetail.setItemId(1L);
       orderDetail.setCreatedAt(LocalDateTime.now());
       orderDetail.setCreatedBy("Server");

       OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
       Assertions.assertNotNull(newOrderDetail);
    }
}