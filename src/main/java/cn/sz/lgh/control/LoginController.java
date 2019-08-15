package cn.sz.lgh.control;

import cn.sz.lgh.pojo.Users;
import cn.sz.lgh.service.InterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Controller
@RequestMapping("/mc")
public class LoginController {

    /*注入服务层的iUserService*/
    @Autowired
    InterUserService iUserService;


    /**
     * 进行login的逻辑判断
     * @param users 数据库的用户
     * @param request
     * @param response
     * @return 进入登录页/商品详情页
     */
    @RequestMapping(value = "l")
    public String checkedlogin(Users users, HttpServletRequest request , HttpServletResponse response){

        /*通过数据库查找对应的账户*/
        Users myuser = iUserService.chekedlogin(users);
        /*判断用户是否存在*/
        if (myuser!=null){
            request.getSession().setAttribute("myuser",myuser);

            /**
             * 有User用户就进入book页面
             */
            return "forward:/bc/tobook";


        }
            /*
            * 没有就返login页面
            * */
        return "login";



    }
}
