package com.study.store.controller;

import com.study.store.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@ApiIgnore
public class GetController {

    @GetMapping("/header")
    public Header getHeader(){
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
