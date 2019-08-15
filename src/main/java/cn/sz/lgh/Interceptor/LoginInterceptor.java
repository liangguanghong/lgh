package cn.sz.lgh.Interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    private String [] arr = {"mc/l","bc/tobook","bc/tobookinfo",""};


    /**
     *
     * @param myurl
     * @return
     */
    public boolean checkUrl(String myurl){
        //放过静态资源
        if(myurl.endsWith(".jpg")||myurl.endsWith(".png")||myurl.endsWith(".css")||myurl.endsWith(".js")){
            return true;
        }
        //放过需要放过的请求路径
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(myurl)){
                return true;
            }
        }
        return false;
    }


    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("目标方法执行前方法");

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("myuser");
        //获取你的tomcat发布的路径
        String path = request.getContextPath();

        String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


        if(obj==null){
            //获取服务请求发送的地址
            String uri = request.getRequestURI();
            String myurl = null;
            //截取服务请求的路径
            if(uri.contains(";jsessionid")){
                myurl = uri.substring(path.length()+1,uri.indexOf(";jsessionid"));
            }else{
                myurl = uri.substring(path.length()+1);
            }
            System.out.println("myurl:"+myurl);
            if(this.checkUrl(myurl)){
                return true;
            }
            //这里最好是重定向
            response.sendRedirect(basepath);

            return false;
        }

        return true;
    }


    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("目标方法执行后方法");

    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("目标方法的最后方法");

    }

}
