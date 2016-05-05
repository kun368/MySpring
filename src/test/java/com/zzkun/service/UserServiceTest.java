package com.zzkun.service;

import com.zzkun.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by kun on 2016/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-servlet.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("zzk");
        user.setPassword("123456");
        assertEquals(true, userService.register(user));
    }

    @Test
    public void loginCheck() throws Exception {
        User user = new User();
        user.setUsername("zzk");
        user.setPassword("123456");
        assertEquals(true, userService.loginCheck(user));
        user.setPassword("111111");
        assertEquals(false, userService.loginCheck(user));
    }

}