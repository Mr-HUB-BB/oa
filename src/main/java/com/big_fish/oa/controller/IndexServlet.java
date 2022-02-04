package com.big_fish.oa.controller; /**
 * ClassName: ${NAME}
 * Description:
 * date: 2022/2/4 22:36
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */

import com.big_fish.oa.entity.Node;
import com.big_fish.oa.entity.User;
import com.big_fish.oa.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User login_user =(User) session.getAttribute("login_user");
        List<Node> node_list = userService.selectNodeById(login_user.getUserId());
        request.setAttribute("node_list",node_list);
        request.getRequestDispatcher("/index.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
