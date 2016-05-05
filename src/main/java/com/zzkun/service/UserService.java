package com.zzkun.service;

import com.zzkun.dao.UserDao;
import com.zzkun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service用于标注业务层组件
 * Created by kun on 2016/5/5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean register(User user) {
        User u = userDao.findUserByUserName(user.getUsername());
        if(u.getId() == 0) {
            userDao.register(user);
            return true;
        }
        return false;
    }

    public boolean loginCheck(User user) {
        User u = userDao.findUserByUserName(user.getUsername());
        return user.getPassword().equals(u.getPassword());
    }
}
