package www.bjpowernode.cn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String food=request.getParameter("food");
        String username=null;
        int balance=0;

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String writ=null;

        //获取Cookie对象
        Cookie cookieArray[]=request.getCookies();

        //遍历获取 username与balance
        for(Cookie cookie:cookieArray){
            String name=cookie.getName();
            if(name.equals("username")){
                username=cookie.getValue();
            }
            if(name.equals("balance")){
                balance=Integer.valueOf(cookie.getValue());
            }
        }

        //食物判读
        if(food.equals("dumpling_food")){
            System.out.println("饺子"+username);
            System.out.println("饺子余额:"+balance);
            if(balance>=30){
                balance-=30;
                writ="<font style='color:red;font-size:40'>用户"+username+"消费成功</font>";
            }else{
                writ="<font style='color:red;font-size:40'>用户"+username+"余额不足</font>";
            }

        }else if(food.equals("noodles_food")){
            System.out.println("面条");
            System.out.println("面条余额:"+balance);
            if(balance>=20){
                balance-=20;
                writ="<font style='color:red;font-size:40'>用户"+username+"消费成功</font>";
            }else{
                writ="<font style='color:red;font-size:40'>用户"+username+"余额不足</font>";
            }
        }else{
            System.out.println("米饭");
            System.out.println("米饭余额:"+balance);
            System.out.println("用户"+username);
            if(balance>=25){
                balance-=25;
                writ="<font style='color:red;font-size:40'>用户"+username+"消费成功</font>";
            }else{
                writ="<font style='color:red;font-size:40'>用户"+username+"余额不足</font>";
            }
        }
        //返回并更新数据，由于Coofie提取的时key值，所以balance会一直存活
        Cookie newCrd=new Cookie("balance",balance+"");
        response.addCookie(newCrd);
        out.println(writ);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
