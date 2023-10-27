import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.StringReader;

@WebServlet(value = "/test")
public class Test extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("xml");
        if (param == null) param = "";

        var xif = XMLInputFactory.newInstance();

        try {
            var xsr = xif.createXMLStreamReader(new StringReader(param));
            System.out.println(xsr);
        } catch (XMLStreamException e) {
            throw new ServletException(e);
        }

        response.getWriter().println("ok");
    }
}
