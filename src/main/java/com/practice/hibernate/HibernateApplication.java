package com.practice.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.hibernate.entity.Address;
import com.practice.hibernate.entity.Student;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HibernateApplication.class, args);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); //pass fileName only if file is not searching by project
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());
		Student student = new Student("shankar","Pune", true, new Date());
		
		Address address = new Address();
		address.setStreet("blue ridge");
		address.setCity("Pune");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(11);
		
		try (FileInputStream fis = new FileInputStream("C:\\Users\\Shank\\Downloads\\PDData\\Documents\\photo.png")) {
			byte[] data = new byte[fis.available()];
			fis.read(data);
			address.setImage(data);
		}
		Session session = factory.openSession();
		Transaction transaction =session.beginTransaction();
		session.persist(student); //before hibernate v6 there was save method but that is deprecated now
		session.persist(address); //before hibernate v6 there was save method but that is deprecated now
		transaction.commit();
		session.close();
		factory.close();
	}

}
