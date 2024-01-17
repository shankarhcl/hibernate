package com.practice.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.hibernate.query.SelectionQuery;

import com.practice.hibernate.entity.Question;
import com.practice.hibernate.entity.Student;

public class HQLDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		String query1 = "From Student"; //Student is Entity name
			Query<Student> q1 = session.createQuery(query1, Student.class); //createQuery(String query)deprecated in 6.3
		List<Student>	list1 = q1.getResultList();
		for (Student student : list1) {
			System.out.println(student.getCity()+" : "+student.getCertificate().getCourse());
		}
		
		String query2 = "From Student where city = 'California'"; //city is field name of Student class
		Query<Student> q2 = 	session.createQuery(query2,Student.class); 
		List<Student>	list2 = q2.list();
		for (Student student : list2) {
			System.out.println(student.getCity()+" : "+student.getCertificate().getCourse());
		}
		
		String query3 = "From Student where city = :x"; //x is parameter that we will set in q3
		Query<Student> q3 = 	session.createQuery(query3, Student.class); 
		q3.setParameter("x", "California");
		List<Student>	list3 = q3.list();
		for (Student student : list3) {
			System.out.println(student.getCity()+" : "+student.getCertificate().getCourse());
		}
		
		String query4 = "From Student where city = :x and name=:y";
		Query<Student> q4 = 	session.createQuery(query4, Student.class); 
		q4.setParameter("x", "California");
		q4.setParameter("y", "Nick");
		List<Student>	list4 = q4.list();
		for (Student student : list4) {
			System.out.println(student.getName()+" : "+student.getCertificate().getCourse());
		}
		
		String query5 = "From Student s where s.name = :a"; //s is alias name
		Query<Student> q5 = 	session.createQuery(query5, Student.class); 
		q5.setParameter("a", "Amanda");
		List<Student>	list5 = q5.list();
		for (Student student : list5) {
			System.out.println(student.getName()+" : "+student.getCertificate().getCourse());
		}
		//delete query
		Transaction tx = session.beginTransaction();
		String query6 = "Delete From Student s where s.name = :a";
		Query<Student> q6 = session.createQuery(query6);  // QueryProducer.createQuery(jakarta.persistence.criteria.CriteriaDelete) in updated version
		q6.setParameter("a", "Harry");
		int noOfRowsDeleted =	q6.executeUpdate();
		System.out.println("No of rows deleted: "+ noOfRowsDeleted);
		
		//update query
		String query7 = "Update Student s set s.city = :c where s.name=:n";
		Query<Student> q7 = session.createQuery(query7); //QueryProducer.createQuery(jakarta.persistence.criteria.CriteriaUpdate) in updated version
		q7.setParameter("c", "New York");
		q7.setParameter("n", "Amanda");
		int noOfRowsUpdated =	q7.executeUpdate();
		System.out.println("No. of rows updated: "+ noOfRowsUpdated);
		
		//join
		String query8 = "Select q.question, q.questionId, a.answer, a.answerId from Question q Inner Join q.answer a"; //also can use Question as q Inner Join q.answer as a 
		Query<Object[]> q8 = 	session.createQuery(query8, Object[].class); 
		List<Object[]> list8 =	q8.getResultList(); //OR list()
		for (Object[] objects : list8) {
			System.out.println(Arrays.toString(objects));
		}
		tx.commit();
		session.close();
		factory.close();
	}

}
