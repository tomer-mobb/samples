import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;

public class BasicSSRF extends HttpServlet {
	private static final String VALID_URI = "http://lgtm.com";
	private HttpClient client = HttpClient.newHttpClient();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException {
		try {
			// BAD: a request parameter is incorporated without validation directly
			HttpRequest r1 = HttpRequest.newBuilder(new URI(request.getParameter("uri"))).build();
			client.send(r1, null);

			// BAD: a request parameter is incorporated without validation using a single tainted variable
			URI uri1 = new URI(request.getParameter("uri"));
			HttpRequest r2 = HttpRequest.newBuilder(uri1).build();
			client.send(r2, null);
			
			// BAD: a request parameter is incorporated without validation using multi tainted variable
			String myUri = request.getParameter("uri");
			URI uri2 = new URI(myUri);
			HttpRequest r3 = HttpRequest.newBuilder(uri2).build();
			client.send(r3, null);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
