package com.cumt.video.service;

import com.cumt.video.dataobject.User;

public interface UserService {

    /*
     * 判斷用戶名是否存在
     * */
    public boolean queryuserNameIsExist(String username);

    /*
     * 保存用户
     * */
    public void saveUser(User user);

    /*
     * 根据用户名查找用户
     * */
    User findUserByUsername(String username);

    /**
     *
     */
    User queryUserByUserId(Integer userId);
}
