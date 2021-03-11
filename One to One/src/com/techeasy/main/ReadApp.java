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
		
		int id=1;
		//retrieve User Object
		User user = session.get(User.class, id);
		
		System.out.println("User:"+user);
		System.out.println("Associated Object User Info:"+user.getUserInfo());
		
		
		//close factory
		factory.close();
		
	}
}
