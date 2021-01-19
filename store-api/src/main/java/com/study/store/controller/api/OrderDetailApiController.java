package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.entity.OrderDetail;
import com.study.store.model.network.request.OrderDetailApiRequest;
import com.study.store.model.network.response.OrderDetailApiResponse;
import com.study.store.service.OrderDetailApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {

//    @Autowired
//    private OrderDetailApiLogicService orderDetailApiLogicService;
//
//    @PostConstruct
//    public void init(){
//        this.baseService = orderDetailApiLogicService;
//    }
}
