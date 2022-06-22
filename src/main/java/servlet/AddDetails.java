package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controller.HibernateUtility;
import domain.UserDetails;
import domain.UserProduct;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addDetails")
public class AddDetails extends HttpServlet {
	
		public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
			
			HttpSession session=request.getSession();
			Session sess=HibernateUtility.getSessionFactory().getCurrentSession();
			System.out.println(sess);
			String title=request.getParameter("title");
			String image=request.getParameter("image");
			System.out.println(image);
			String quantity=request.getParameter("quantity");
			int  size=Integer.parseInt(request.getParameter("size"));
			List<UserProduct> list=new ArrayList<UserProduct>();
			Transaction tx=sess.beginTransaction();
			TypedQuery<UserDetails> t1=sess.createQuery("from UserDetails where username=:user");
			t1.setParameter("user",session.getAttribute("username"));
			UserDetails val=(UserDetails)t1.getSingleResult();
			
			UserProduct prod=new UserProduct();
			prod.setName(title);
			prod.setQuantity(quantity);
			prod.setSize(size);
			prod.setDetails_id(val);
		
				
			String ad="C:\\Users\\ayushigupta01\\Desktop\\image\\"+image;
			FileInputStream fis=new FileInputStream(ad);
			byte[] data=new byte[fis.available()];
			fis.read(data);
			prod.setImage(data);

			list.add(prod);
			
			val.setProductId(list);
			
			sess.save(val);
			sess.save(prod);
			tx.commit();
			response.sendRedirect("product.jsp");
			fis.close();
		}
}
