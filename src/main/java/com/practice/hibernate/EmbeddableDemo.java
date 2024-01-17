package com.practice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Student;
import com.practice.hibernate.model.Certificate;

public class EmbeddableDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Certificate certificate1 = new Certificate("Hibernate Series", "10 Hrs");		
		Student student1 = new Student("Nick","California",true,new Date(),certificate1);
		
		Certificate certificate2 = new Certificate("Spring Boot Series", "12 Hrs");		
		Student student2 = new Student("Harry","Canada",true,new Date(),certificate2);
		
		Certificate certificate3 = new Certificate("Spring MVC Series", "20 Hrs");		
		Student student3 = new Student("Amanda","New Jersy",true,new Date(),certificate3);
		
		Certificate certificate4 = new Certificate("Java8 Series", "10 Hrs");		
		Student student4 = new Student("Irum","California",true,new Date(),certificate4);
		
		Certificate certificate5 = new Certificate("Collection Series", "5 Hrs");		
		Student student5 = new Student("Ken","Siberia",true,new Date(),certificate5);
		
		Certificate certificate6 = new Certificate("OOPS Series", "8 Hrs");		
		Student student6 = new Student("Pramod","banglore",true,new Date(),certificate6);
		
		Certificate certificate7 = new Certificate("DSA Series", "50 Hrs");		
		Student student7 = new Student("Priyanka","Pune",true,new Date(),certificate7);
		
		Certificate certificate8 = new Certificate("Design Series", "50 Hrs");		
		Student student8 = new Student("Aarti","California",true,new Date(),certificate8);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		session.persist(student4);
		session.persist(student5);
		session.persist(student6);
		session.persist(student7);
		session.persist(student8);
		tx.commit();
		session.close();
		factory.close();
	}
}
