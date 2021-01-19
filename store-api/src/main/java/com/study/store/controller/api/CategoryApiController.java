package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.network.request.CategoryApiRequest;
import com.study.store.model.network.response.CategoryApiResponse;
import com.study.store.service.CategoryApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryApiLogicService categoryApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = categoryApiLogicService;
    }
}
