package com.example.demo.impl;

import com.example.demo.interf.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author bruce
 */
@Service
public class LoginServiceImpl implements LoginService {

    public Boolean login() {
        return true;
    }
}
