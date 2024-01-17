package com.practice.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Geek;
import com.practice.hibernate.entity.Project;

public class ManyToManyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Geek geek1 = new Geek();
		geek1.setGname("Harry");
		Geek geek2 = new Geek();
		geek2.setGname("Garry");
		Project project1=new Project();
		project1.setPname("Library management system");
		Project project2=new Project();
		project2.setPname("chatbot");
		project2.setPname("CMS service");
		List<Geek> geekList =  new ArrayList<>();
		geekList.add(geek1);
		geekList.add(geek2);
		List<Project> projectList =  new ArrayList<>();
		projectList.add(project1);
		projectList.add(project2);
		geek1.setProjects(projectList);
		project2.setGeeks(geekList);

		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(geek1);
		session.persist(geek2);
		session.persist(project1);
		session.persist(project2);

		tx.commit();
		session.close();
		factory.close();
	}
}
