package com.practice.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Food;
import com.practice.hibernate.entity.Restaurant;

public class FetchTypeDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Restaurant restaurant1=new Restaurant();
		Restaurant restaurant2=new Restaurant();
		restaurant1.setRestaurantName("Bird Valley");
		Food food1 = new Food();
		Food food2 = new Food();
		food1.setFoodName("fried Rice");
		food1.setRestaurant(restaurant1);
		food2.setFoodName("Boiled Rice");
		food2.setRestaurant(restaurant1);
		List<Food> foodList1 = new ArrayList<>();
		foodList1.add(food1);
		foodList1.add(food2);
		
		restaurant2.setRestaurantName("Mezza9");
		Food food3 = new Food();
		Food food4 = new Food();
		food3.setFoodName("Sizzler");
		food3.setRestaurant(restaurant2);
		food4.setFoodName("Hakka Noodles");
		food4.setRestaurant(restaurant2);
		List<Food> foodList2 = new ArrayList<>();
		foodList2.add(food3);
		foodList2.add(food4);
		restaurant2.setFoods(foodList2);
		
		Session session = factory.openSession();
		session.persist(restaurant1);
		session.persist(restaurant2);
		session.persist(food1);
		session.persist(food2);
		session.persist(food3);
		session.persist(food4);
		Transaction tx = session.beginTransaction();
		tx.commit();

		//fetch data by lazy loading as data will be load only when we call getter methods on  it
		Restaurant restaurant = session.get(Restaurant.class, 1);
		System.out.println(restaurant.getRestaurantName()); //Bird Valley
		System.out.println(restaurant.getRestaurantId());   //1
		
		System.out.println(restaurant.getFoods().size());   //2 (If we don't write fetch=FetchType.EAGER in Restaurant class then select query will be fired on Food Table for this operation due to lazy loading
																//but if we enable eager loading then Food data will lopd immediately when we load restaurant data and hibernate will call select query with left join between tables whether we call getFoods() or not. Output will same in both case )
		session.close();
		factory.close();
	}
}
