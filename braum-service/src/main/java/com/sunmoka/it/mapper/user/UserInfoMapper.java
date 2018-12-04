package com.sunmoka.it.mapper.user;

import com.sunmoka.it.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    public List<UserInfo> selectAll();
}
