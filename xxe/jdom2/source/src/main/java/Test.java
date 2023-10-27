import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

@WebServlet(value = "/test")
public class Test extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("xml");
        if (param == null) param = "";

        SAXBuilder builder = new SAXBuilder();
        Document document = null;

        try {
            document = builder.build(new StringReader(param));
            System.out.println(document);
        } catch (JDOMException e) {
            throw new ServletException(e);
        }

        response.getWriter().println("ok");
    }
}
