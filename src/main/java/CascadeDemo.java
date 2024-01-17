import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.practice.hibernate.entity.City;
import com.practice.hibernate.entity.Country;
import com.practice.hibernate.entity.Student;

public class CascadeDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		Session session = factory.openSession();
		
		Country country1 = new Country();
		country1.setCountryName("INDIA");
		City city1 = new City();
		City city2 = new City();
		City city3 = new City();
		city1.setCityName("Pune");
		city1.setCountry(country1);
		city2.setCityName("Mumbai");
		city2.setCountry(country1);
		city3.setCityName("Banglore");
		city3.setCountry(country1);
		List<City> cityList1 = new ArrayList<>();
		cityList1.add(city1);
		cityList1.add(city2);
		cityList1.add(city3);
		country1.setCities(cityList1);
		
		Country country2 = new Country();
		country2.setCountryName("US");
		City city4 = new City();
		City city5 = new City();
		City city6 = new City();
		city4.setCityName("Chicago");
		city4.setCountry(country2);
		city5.setCityName("Boston");
		city5.setCountry(country2);
		city6.setCityName("Los Angeles");
		city6.setCountry(country2);
		List<City> cityList2 = new ArrayList<>();
		cityList2.add(city4);
		cityList2.add(city5);
		cityList2.add(city6);
		country2.setCities(cityList2);
		
		
		Transaction tx = session.beginTransaction();
		session.persist(country1);
		session.persist(country2);
		//No need to persist cities if we will use cascading. The city table will be created automatically and data will be load
		tx.commit();
		session.close();
		factory.close();
	}
}
