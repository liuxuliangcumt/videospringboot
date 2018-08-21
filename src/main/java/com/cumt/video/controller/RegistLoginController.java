package com.cumt.video.controller;

import com.cumt.video.data.pojo.common.Desc;
import com.cumt.video.data.pojo.common.MapResult;
import com.cumt.video.dataobject.User;
import com.cumt.video.params.LoginParam;
import com.cumt.video.service.UserService;
import com.cumt.video.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RegistLoginController {

    @Autowired
    UserService userService;

    @PostMapping("/regist")
    public String regist(@RequestBody LoginParam param) {
        // return "注册成功";  (value="password",required=false)
        boolean isExit = userService.queryuserNameIsExist(param.getUsername());
        if (isExit) {
            return "用户名已存在";
        } else {
            User user = new User();
            user.setUserName(param.getUsername());
            user.setNickname(param.getUsername());
            try {
                user.setPassWord(MD5Utils.getMD5Str(param.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            userService.saveUser(user);
            return "注册成功";
        }

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginParam param) {
        // return "注册成功";  (value="password",required=false)
        User user = userService.findUserByUsername(param.getUsername());
        String pasword = "";
        try {
            pasword = MD5Utils.getMD5Str(param.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Desc desc = new Desc();
        if (user == null) {
            desc.setDescription("用户名或密码不正确");
            desc.setCode("2");
        } else {
            if (user.getPassWord().equals(pasword)) {
                desc.setDescription("查询成功");
                desc.setCode("1");
            } else {
                desc.setDescription("用户名或密码不正确");
                desc.setCode("2");
            }
        }
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("", desc, user), HttpStatus.OK);

    }


    @PostMapping("/query")
    public ResponseEntity<Map<String, Object>> query(@RequestBody LoginParam param) {


        User user = userService.queryUserByUserId(param.getUserId());
        Desc desc = new Desc();

        if (user != null) {
            desc.setDescription("查询成功");
            desc.setCode("1");
        } else {
            desc.setDescription("用戶不存在");
            desc.setCode("2");
        }
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("", desc, user), HttpStatus.OK);
    }
}
