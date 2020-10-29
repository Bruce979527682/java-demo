package com.example.demo.controllers;

import com.example.demo.common.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping(value = "/health", method = { RequestMethod.GET, RequestMethod.POST})
    public BaseResponse<Boolean> health(){
        return new BaseResponse(0, "", true);
    }
}
