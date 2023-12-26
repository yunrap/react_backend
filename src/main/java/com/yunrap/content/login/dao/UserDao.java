package com.yunrap.content.login.dao;

import com.yunrap.content.login.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserDao {

    /**
     * 사용자조회
     *
     * @return
     * @throws
     */
    public UserVo getUserList(String userName);

}
