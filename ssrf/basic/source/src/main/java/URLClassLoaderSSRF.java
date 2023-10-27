import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class URLClassLoaderSSRF extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String url = request.getParameter("uri");
            URI uri = new URI(url);
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{uri.toURL()}); // $ SSRF
            Class<?> test = urlClassLoader.loadClass("test");
        } catch (Exception e) {
            // Ignore
        }
    }
}
