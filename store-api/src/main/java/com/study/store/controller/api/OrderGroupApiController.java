package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.entity.OrderGroup;
import com.study.store.model.network.request.OrderGroupApiRequest;
import com.study.store.model.network.response.OrderGroupApiResponse;
import com.study.store.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

//    @Autowired
//    OrderGroupApiLogicService orderGroupApiLogicService;
//
//    @PostConstruct
//    public void init(){
//        this.baseService = orderGroupApiLogicService;
//    }
}
