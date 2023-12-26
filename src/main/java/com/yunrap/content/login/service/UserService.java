package com.yunrap.content.login.service;

import com.yunrap.content.login.JwtTokenProvider;
import com.yunrap.content.login.dao.UserDao;
import com.yunrap.content.login.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String createToken(UserVo userVo) {
        System.out.println(userVo.getUserName() + "확인");

        UserVo userList = userDao.getUserList(userVo.getUserName());

        System.out.println(userList);
        return jwtTokenProvider.createToken(userList.getUserName());
    }

}
