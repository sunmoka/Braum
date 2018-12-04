package com.sunmoka.it.service;

import com.sunmoka.it.entity.UserInfo;
import com.sunmoka.it.mapper.user.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAll() {
        return userInfoMapper.selectAll();
    }
}
