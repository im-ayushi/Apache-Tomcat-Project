package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.UserDetails;
import domain.UserProduct;

public class HibernateUtility {

	public static SessionFactory sf;

	private HibernateUtility(){	
	}

	public static synchronized SessionFactory getSessionFactory() {

		if (sf == null) {
			sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserDetails.class).addAnnotatedClass(UserProduct.class).buildSessionFactory();
			Session session=sf.openSession();
			return sf;
		}
		return sf;
	}
}
