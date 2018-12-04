package com.sunmoka.it.controller;

import com.sunmoka.it.entity.UserInfo;
import com.sunmoka.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("all")
    public List<UserInfo> getAll() {
        return userInfoService.getAll();
    }
}
