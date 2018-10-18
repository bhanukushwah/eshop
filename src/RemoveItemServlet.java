

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/removeitem")
public class RemoveItemServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a[]=request.getParameterValues("ritem");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		ArrayList <String> al=(ArrayList<String>) session.getAttribute("list");
		for(String e:al) {
			al.remove(e);
		}
		response.sendRedirect("viewcart");
	}

}
