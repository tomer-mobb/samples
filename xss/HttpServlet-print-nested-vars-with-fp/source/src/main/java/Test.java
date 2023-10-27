import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Test extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String res = "<div>";
        res += a;
        res += "</div>";
        res = "<div>" + b + "</div>" + "<div>" + request.getParameter("c") + "</div>";

        response.getWriter().print(res);
        response.getWriter().flush();
    }
}
