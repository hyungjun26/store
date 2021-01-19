package com.study.store.controller.api;

import com.study.store.controller.CrudController;
import com.study.store.model.entity.AdminUser;
import com.study.store.model.network.request.AdminUserApiRequest;
import com.study.store.model.network.response.AdminUserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {


}
