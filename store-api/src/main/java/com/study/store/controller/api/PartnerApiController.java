package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.network.request.PartnerApiRequest;
import com.study.store.model.network.response.PartnerApiResponse;
import com.study.store.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = partnerApiLogicService;
    }
}
