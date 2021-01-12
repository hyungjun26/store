package com.study.store.repository;

import com.study.store.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("ItemRepositoryTest")
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Rollback(value = false)
    public void create(){
        Item item = new Item();
        item.setName("맥북 프로");
        item.setPrice(3500000);
        item.setContent("2020 맥북 프로 16인치");

        Item newItem = itemRepository.save(item);

        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);
        Assertions.assertTrue(item.isPresent());
    }
}