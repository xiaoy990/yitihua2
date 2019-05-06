package com.xiaoy.user.service.userservice;

import com.xiaoy.user.entity.users.User;

public interface UserService {

    User getUserByName(String name);

    void addUser(User user);
}
