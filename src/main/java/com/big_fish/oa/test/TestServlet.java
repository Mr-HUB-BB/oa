package com.big_fish.oa.test; /**
 * ClassName: ${NAME}
 * Description:
 * date: 2022/1/29 21:58
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */

import com.big_fish.oa.utils.MybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "testServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = (String) MybatisUtils.executeQuery(session -> session.selectOne("test.sample"));
        request.setAttribute("result",s);
        request.getRequestDispatcher("/test.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
