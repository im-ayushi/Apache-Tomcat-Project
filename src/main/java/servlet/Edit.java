package servlet;

import java.io.IOException;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		Session sess=HibernateUtility.getSessionFactory().getCurrentSession();
		String title=request.getParameter("title");
		String quantity=request.getParameter("quantity");
		int  size=Integer.parseInt(request.getParameter("size"));
		int pid=(Integer) session.getAttribute("pid");
		System.out.println(pid);
		Transaction tx=sess.beginTransaction();
		TypedQuery t1=sess.createQuery("update UserProduct set name=:title,quantity=:quantity, size=:size where sno=:id");
		t1.setParameter("title", title);
		t1.setParameter("quantity", quantity);
		t1.setParameter("size", size);
		t1.setParameter("id", pid);
		t1.executeUpdate();
		tx.commit();
		response.sendRedirect("product.jsp");
	}
}
