import org.xml.sax.InputSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

@WebServlet(value = "/test")
public class Test extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("xml");
        if (param == null) param = "";

        var s = new SAXSource(new InputSource(new StringReader(param)));
        var r = new StreamResult(new FileOutputStream("out.xml"));

        try {
            TransformerFactory.newInstance().newTransformer().transform(s, r);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

        response.getWriter().println("ok");
    }
}
