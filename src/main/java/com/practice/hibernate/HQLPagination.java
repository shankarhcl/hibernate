package com.practice.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.practice.hibernate.entity.Student;

public class HQLPagination {
public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		Session session = factory.openSession();
		String query1 = "From Student";
		Query<Student> q1 = session.createQuery(query1, Student.class);
		q1.setFirstResult(0); //first page will start from 0
		q1.setMaxResults(2); //maximum 2 pages will come i.e. 0,1
		List<Student>	list1 = q1.getResultList();
		for (Student student : list1) {
			System.out.println(student.getId()+" : "+student.getName());
		}
		session.close();
		factory.close();
	}
}
