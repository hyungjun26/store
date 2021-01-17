package com.study.store.controller.api;

import com.study.store.interfaces.CrudInterface;
import com.study.store.model.network.Header;
import com.study.store.model.network.request.UserApiRequest;
import com.study.store.model.network.response.UserApiResponse;
import com.study.store.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("request : {}", request);
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name = "id") Long id) {
        log.info("delete : {}", id);
        return userApiLogicService.delete(id);
    }


}
