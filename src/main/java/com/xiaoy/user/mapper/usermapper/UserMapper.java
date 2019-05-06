package com.xiaoy.user.mapper.usermapper;

import com.xiaoy.user.entity.users.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getUserByName(@Param("user_name") String user_name);

    void addUser(@Param("user") User user);

}
