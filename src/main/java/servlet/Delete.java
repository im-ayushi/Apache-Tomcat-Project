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

@WebServlet("/del")
public class Delete extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		Session sess=HibernateUtility.getSessionFactory().getCurrentSession();
		int num=Integer.parseInt(request.getParameter("pid"));
		String str="Delete from UserProduct p where p.sno="+num;
		Transaction tx=sess.beginTransaction();
		TypedQuery t1=sess.createQuery(str);
		
		t1.executeUpdate();
		tx.commit();
		System.out.println(num);
		response.sendRedirect("product.jsp");
	}
}
