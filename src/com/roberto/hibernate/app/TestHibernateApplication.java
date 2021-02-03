package com.roberto.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.roberto.hibernate.model.HbStudent;

public class TestHibernateApplication {

	public static void main(String[] args) {

		// create session factory from 'hibernate.cfg.xml'
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(HbStudent.class)
										.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new hbstudent object...");
			HbStudent tempStudent = new HbStudent("Paul", "Doe", "paul@luv2code.com");
			
			// start a transaction
			// ##########################################
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			// ##########################################
			
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("error occured in save HbStudent class");
			e.printStackTrace();
		}
		finally {
			if(factory != null && factory.isOpen()) {
				factory.close();
			}
		}
	}
}
