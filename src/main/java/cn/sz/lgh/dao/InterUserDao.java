package cn.sz.lgh.dao;

import cn.sz.lgh.pojo.Users;

public interface InterUserDao {
    //查询用户
    public Users selectUserBylogininfo(Users u);
}
