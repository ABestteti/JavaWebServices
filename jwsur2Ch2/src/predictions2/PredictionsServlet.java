package predictions2;

import java.util.Arrays;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PredictionsServlet extends HttpServlet {
	private Predictions predictions; // Backend bean

	// Executed when servlet is first loaded into container
	// Create a Predictions object and set its servletContext
	// property so that the object can do I/O.
	@Override
	public void init() {
		predictions = new Predictions();
		predictions.setServletContext(this.getServletContext());
	}

	// GET /predictions2
	// GET /predictions2?id=1
	// If the HTTP Accept headers is set to application/jason (or an equivalent
	// such as text/x-json), the response is JSON and XML otherwise.
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String param = request.getParameter("id");
		Integer key = (param == null) ? null : new Integer(param.trim());
		
		// Check the user preference for XML or JSON by inspecting
		// the HTTP headers for the Accept Key.
		boolean json = false;
		String accept = request.getHeader("accept");
		
		if (accept != null && accept.contains("json")) {
			json = true;
		}
		
		// If no query string, assume client wants the full list.
		if (key == null) {
			ConcurrentMap<Integer, Prediction> map = predictions.getMap();
			
			// Sort the map's values for readability.
			Object[] list = map.values().toArray();
			
			Arrays.sort(list);
			
			String xml = predictions.toXML(list);
			
			sendResponse(response, xml, json);
		}
		else {
			// Otherwise, return the specified prediction
			
		}
	}

}
