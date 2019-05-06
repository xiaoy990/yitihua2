package com.xiaoy.user;

import com.xiaoy.user.entity.users.User;
import com.xiaoy.user.service.userservice.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
    @Resource
    UserService userService;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setPerms("user.add");
        user.setUser_name("1");
        user.setPassword("1");
        userService.addUser(user);
        System.out.println(userService.getUserByName("1"));
    }

}
