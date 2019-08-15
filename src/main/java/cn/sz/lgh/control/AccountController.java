package cn.sz.lgh.control;


import cn.sz.lgh.pojo.Account;
import cn.sz.lgh.pojo.Users;
import cn.sz.lgh.service.InterAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ac")
public class AccountController {
/*
*在Spring里面的注解注入,其实是spring调用了jdk的动态代理,所有,所有的注入都应该是接口
*
* */
    @Autowired
    private InterAccountService iAccountService;

    /**
     * 通过ajax的方式获取账户
     * @param request 通过request.getSession()获取登录成功的用户信息
     * @return 用户所拥有的所有账户
     */

    @RequestMapping(value = "toCheckAccount")
    @ResponseBody
    public List<Account> toCheckAccount( HttpServletRequest request)   {
       //获取用户信息
        Users users = (Users)request.getSession().getAttribute("myuser");
        //获取用户的所有账号
        List<Account> accounts = iAccountService.accountByUserid(users.getUserid());
        return accounts;
 }

    /**
     * 通过ajax
     * @param accid 通过账户的编号
     * @return 账户的金额
     */
    @RequestMapping(value = "toCheckBalance")
    @ResponseBody
    public Double toCheckBalance(Integer accid){
        //获取这个账号的金额
        Double aDouble = iAccountService.selectAccountbyAccid(accid);
        return aDouble;

    }
}
