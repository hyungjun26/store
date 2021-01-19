package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.entity.Item;
import com.study.store.model.network.request.ItemApiRequest;
import com.study.store.model.network.response.ItemApiResponse;
import com.study.store.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {
//
//    @Autowired
//    private ItemApiLogicService itemApiLogicService;
//
//    @PostConstruct
//    public void init(){
//        this.baseService = itemApiLogicService;
//    }

}
