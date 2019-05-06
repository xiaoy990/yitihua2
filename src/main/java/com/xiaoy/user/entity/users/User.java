package com.xiaoy.user.entity.users;

import javax.persistence.*;

@Entity
@Table(name = "t_users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 20)
    private String user_name;

    @Column(length = 20)
    private String password;

    @Column(length = 128)
    private String perms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }
}
