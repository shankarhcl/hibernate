package com.practice.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Account;
import com.practice.hibernate.entity.Employee;

public class OneToManyAndManyToOneDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee emp1 = new Employee();
		emp1.setEname("Nick");
		Account acc1 = new Account();
		acc1.setType("Cuurent Account");
		acc1.setEmployee(emp1);
		Account acc2 = new Account();
		acc2.setType("Saving Account");
		acc2.setEmployee(emp1);
		List<Account> accList1 = new ArrayList<>();
		accList1.add(acc1);
		accList1.add(acc2);
		emp1.setAccounts(accList1);
		
		Employee emp2 = new Employee();
		emp2.setEname("Jone");
		Account acc3 = new Account();
		acc3.setType("Wallet Account");
		acc3.setEmployee(emp2);
		Account acc4 = new Account();
		acc4.setType("Demat Account");
		acc4.setEmployee(emp2);
		List<Account> accList2 = new ArrayList<>();
		accList2.add(acc3);
		accList2.add(acc4);
		emp1.setAccounts(accList2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(emp1);
		session.persist(emp2);
		session.persist(acc1);
		session.persist(acc2);
		session.persist(acc3);
		session.persist(acc4);

		tx.commit();
		session.close();
		factory.close();
	}

}
