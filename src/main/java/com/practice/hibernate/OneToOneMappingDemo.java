package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Answer;
import com.practice.hibernate.entity.Question;

public class OneToOneMappingDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question que1 = new Question();
		que1.setQuestion("What is Hibernate?");
		Answer ans1 = new Answer();
		ans1.setAnswer("Hibernate is ORM Tool.");
		ans1.setQuestion(que1);
		que1.setAnswer(ans1);
		
		Question que2 = new Question();
		que2.setQuestion("What is Labda expression?");
		Answer ans2 = new Answer();
		ans2.setAnswer("Lambda is annonymous function having no ret type, no access modifier, and no name.");
		ans2.setQuestion(que2);
		que2.setAnswer(ans2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(que1);
		session.persist(que2);

		session.persist(ans1);
		session.persist(ans2);
		tx.commit();
		session.close();
		factory.close();
	}

}
