package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Address;
import com.practice.hibernate.entity.Student;

public class FetchDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Student student = 	session.load(Student.class, 1); //load() deprecated in hibernate 6
		System.out.println("data fetched on behalf of load method: "+student);
		
		Student student1 = 	session.load(Student.class, 1); 
		System.out.println("data will be fetched  from cache as only 1 select query will be fired in  logs: "+student1);
		System.out.println(student.getCity());

		Address address = session.get(Address.class, 2);
		System.out.println("data fetched on behalf of get method: "+address);
		System.out.println(address.getCity());
		
		Address address1 = session.get(Address.class, 2);
		System.out.println("data will be fetched  from cache as only 1 select query will be fired in  logs: "+address1);
		System.out.println(address.getCity());

		session.close();
		factory.close();
	}
}
