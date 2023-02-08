package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		ServletConfig config = getServletConfig();
		response.setContentType("text/html");
		Enumeration<String> parameterNames = config.getInitParameterNames();
		out.println("<center>");
		out.println("<table border='1'");
		out.println("<tr><th>Param-Name</th><td>Param-Value</td></tr>");
		while (parameterNames.hasMoreElements()) {
			out.println("<tr>");
			String name = (String) parameterNames.nextElement();
			String value = config.getInitParameter(name);

			out.println("<th>" + name + "</th><td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center/>");

	}

}
