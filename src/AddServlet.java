

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a[]=request.getParameterValues("item");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		ArrayList <String> al=(ArrayList<String>) session.getAttribute("list");
		if(al==null) {
			al=new ArrayList <>();
			session.setAttribute("list",al);
		}
		for(String e:a) {
			al.add(e);
		}
		out.println("<a href=\"viewcart\">View Cart</a>");
	}

}
