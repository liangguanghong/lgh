package cn.sz.lgh.service;

import cn.sz.lgh.dao.InterUserDao;
import cn.sz.lgh.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements InterUserService {

        /*加入注入dao*/
        @Autowired
        InterUserDao iUserDao;

    public Users chekedlogin(Users users) {
        if (users.getLoginname() == null || users.getLoginpwd() == null && users.getLoginname().equals("") || users.getLoginpwd().equals("")) {
            return null;
        }
        return iUserDao.selectUserBylogininfo(users);


    }

}

