package com.techeasy.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techeasy.entity.User;
import com.techeasy.entity.UserInfo;

public class CreateApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserInfo.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		//create objects
		User user = new User("sunil14", "sunil14", "ADMIN");
		
		UserInfo userInfo = new UserInfo("Sunil Sahare", "Pune");
		
		user.setUserInfo(userInfo);
		
		//save object
		session.save(user);
		
		//commit transaction
		session.getTransaction().commit();
		
		//close factory
		factory.close();
		
	}
}
