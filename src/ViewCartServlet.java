

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		HttpSession session=request.getSession();
		ArrayList <String> al=(ArrayList<String>) session.getAttribute("list");
		
		if(al==null) {
			al=new ArrayList <>();
			session.setAttribute("list",al);
		}
		out.println("<form action=\"removeitem\"");
		for(String e:al) {
			out.println("<input type=\"checkbox\" name=\"ritem\" value=\"e\">"+e+"<br>");
			out.println("<br>");
		}
		out.println("<p><input type=\"submit\" value=\"Remove Item\"></td></p>");
		out.println("</form>");
		out.println("<hr>");
		out.println("<a href=\"catelog.html\">Add More Item</a>");
		out.println("</body></html>");
	}

}
