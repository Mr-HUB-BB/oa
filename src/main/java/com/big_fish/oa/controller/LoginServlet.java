package com.big_fish.oa.controller; /**
 * ClassName: ${NAME}
 * Description:
 * date: 2022/1/30 1:42
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */

import com.alibaba.fastjson.JSON;
import com.big_fish.oa.entity.User;
import com.big_fish.oa.service.UserService;
import com.big_fish.oa.service.exception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/check_login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //接受用户输入
       String username =  request.getParameter("username");
       String password =  request.getParameter("password");
        Map<String,Object> result = new HashMap<>();
        //调用业务逻辑，对账号密码进行校验
        try {
            User user = userService.checkLogin(username, password);
            //校验成功
            result.put("code","0");
            result.put("message","success");
        } catch (BussinessException e) { //账号、密码错误
           logger.error(e.getMessage(),e);
            result.put("code",e.getCode());
            result.put("message",e.getMessage());
        }catch (Exception e){ // 程序异常
          logger.error(e.getMessage(),e);
            result.put("code",e.getClass().getSimpleName());
            result.put("message",e.getMessage());
        }
        //校验完成后将校验结果转为Json字符串输出，返回对应结果
        String jsonString = JSON.toJSONString(result);
        response.getWriter().println(jsonString);



    }
}
