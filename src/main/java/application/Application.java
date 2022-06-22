package application;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import dao.ValidateUsername;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/check")
public class Application extends HttpServlet {

		public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			String username=request.getParameter("user");
			String password =request.getParameter("pass");
			Session sess=ValidateUsername.fetch(username,password);
			HttpSession session=request.getSession();
			
			
			if(sess!=null){
				session.setAttribute("arg",sess);
				session.setAttribute("username", username);
				response.sendRedirect("product.jsp");
			}else {
				PrintWriter out =response.getWriter();
				out.println("Wrong Password");
			}			
		}

}
