package com.phase2.programs;

import java.util.HashMap;    
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;    
  
  
public class MapCollectionMain {    
public static void main(String[] args) {    
   
	Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
 
    SessionFactory sessionFactory = cfg.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction t = session.beginTransaction();
HashMap<String,String> map1=new HashMap<String,String>();    
    map1.put("Java is a programming language","John Milton");    
    map1.put("Java is a platform","Ashok Kumar");    
        
    HashMap<String,String> map2=new HashMap<String,String>();    
    map2.put("Servlet technology is a server side programming","John Milton");    
    map2.put("Servlet is an Interface","Ashok Kumar");    
    map2.put("Servlet is a package","Rahul Kumar");    
        
    QuestionMap question1=new QuestionMap("What is Java?","Alok",map1);    
    QuestionMap question2=new QuestionMap("What is Servlet?","Jai Dixit",map2);    
        
    session.persist(question1);    
    session.persist(question2);    
        
    t.commit();    
    session.close();    
    System.out.println("successfully stored");    
}    
}    

