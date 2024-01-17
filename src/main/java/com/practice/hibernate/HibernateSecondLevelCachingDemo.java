package com.practice.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Teacher;
import com.practice.hibernate.model.Certificate;

public class HibernateSecondLevelCachingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		
		/*
		 * Certificate certificate1 = new Certificate("Hibernate Series", "10 Hrs");
		 * Teacher teacher1 = new Teacher("Nick","California",certificate1); Certificate
		 * certificate2 = new Certificate("Spring Boot Series", "12 Hrs"); Teacher
		 * teacher2 = new Teacher("Harry","Canada",certificate2);
		 */
		
		/*
		 * Transaction tx = session.beginTransaction(); session.persist(teacher1);
		 * session.persist(teacher2);
		 */
		
		Session session = factory.openSession();
		Teacher getTeacher1 = session.get(Teacher.class, 1);
		System.out.println(getTeacher1);
		Teacher getTeacher2 = session.get(Teacher.class, 1);
		System.out.println(getTeacher2);
		
		session.close();
		factory.close();
	}

}
