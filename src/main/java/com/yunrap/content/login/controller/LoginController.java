package com.yunrap.content.login.controller;

import com.yunrap.content.login.service.UserService;
import com.yunrap.content.login.vo.UserVo;
import com.yunrap.content.login.vo.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 로그인
     * @param request
     * @return
     */
    @PostMapping(value ="/login")
    public ResponseEntity<TokenResponse> login(@RequestBody UserVo userVo) {
        String token = userService.createToken(userVo);
        System.out.println(token);
        return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
    }

}
