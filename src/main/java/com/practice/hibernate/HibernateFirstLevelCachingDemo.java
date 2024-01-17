package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Student;

public class HibernateFirstLevelCachingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		Session session = factory.openSession();
		Student student1 = session.get(Student.class, 1); //select query will be fired in db
		System.out.println(student1);	
		Student student2 = session.get(Student.class, 1); //No db call but data will come from Session object that is cache memory
		System.out.println(student2);	
		System.out.println(session.contains(student1));
		session.close();
		factory.close();
	}

}
