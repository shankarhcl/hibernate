package com.practice.hibernate;

import java.lang.annotation.Native;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.practice.hibernate.entity.Student;

public class NativePostgresQueryDemo {
		public static void main(String[] args) {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
			Session session = factory.openSession();
			String query = "Select * from student s"; //student is table name here and not the entity name
			NativeQuery<Student> nativePostgresQuery = 	session.createNativeQuery(query, Student.class, "s"); //here s is alias
			List<Student> list = nativePostgresQuery.getResultList();
			list.forEach(System.out::println);		
			session.close();
			factory.close();
		}
}
