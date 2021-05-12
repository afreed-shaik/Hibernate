package com.control;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;


public class HibernateMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.to.Player.class);
		StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session= factory.openSession();
		Transaction transaction = session.beginTransaction();
		Player p1=new Player(11,"Andy","India",25);
		
		session.save(p1);
		
		transaction.commit();
		session.close();
		
		
		
	}

	
	
}
