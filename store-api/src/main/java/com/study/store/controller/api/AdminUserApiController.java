package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.network.request.AdminUserApiRequest;
import com.study.store.model.network.response.AdminUserApiResponse;
import com.study.store.service.AdminUserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = adminUserApiLogicService;
    }
}
