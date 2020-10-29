package com.example.demo.controllers;

import com.example.demo.common.BaseResponse;
import com.example.demo.interf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bruce
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public BaseResponse<Boolean> login(){
        return new BaseResponse<Boolean>(0, "" , loginService.login());
    }

}
