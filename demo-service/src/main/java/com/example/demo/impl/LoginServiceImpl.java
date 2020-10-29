package com.example.demo.impl;

import com.example.demo.interf.LoginService;
import com.example.demo.model.mapper.AccountMapper;
import com.example.demo.model.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bruce
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean login() {
        //AccountExample example = new AccountExample();
        //example.createCriteria().andIdEqualTo(1);
        Account account = accountMapper.selectByPrimaryKey(1);
        if(account != null){
            return true;
        }
        return false;
    }
}
