import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        XMLReader xmlreader = null;
        MyHandler handler = new MyHandler();
        InputSource is = new InputSource(new StringReader(param));

        try {
            xmlreader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        xmlreader.setContentHandler(handler);

        try {
            xmlreader.parse(is);
        } catch (SAXException e) {
            throw new ServletException(e);
        }

        System.out.println(handler);
        response.getWriter().println("ok");
    }
}
