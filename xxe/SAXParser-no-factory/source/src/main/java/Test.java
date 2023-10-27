import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

@WebServlet(value = "/test")
public class Test extends HttpServlet {
    static class MyHandler extends DefaultHandler {}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("xml");
        if (param == null) param = "";

        SAXParser saxParser;
        MyHandler handler = new MyHandler();

        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new ServletException(e);
        }

        try {
            saxParser.parse(new InputSource(new StringReader(param)), handler);
        } catch (SAXException e) {
            throw new ServletException(e);
        }

        System.out.println(handler);
        response.getWriter().println("ok");
    }
}
