package www.bjpowernode.cn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String balance=request.getParameter("balance");
        Cookie crd1=new Cookie("username",username);
        Cookie crd2=new Cookie("balance",balance);


        response.addCookie(crd1);
        response.addCookie(crd2);

        //通知Tomcat将【点餐页面】内容写到响应体中交给浏览器（请求转发）
        request.getRequestDispatcher("/index_2.html").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
