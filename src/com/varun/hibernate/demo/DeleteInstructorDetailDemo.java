package com.varun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.varun.hibernate.demo.entity.Instructor;
import com.varun.hibernate.demo.entity.InstructorDetail;
import com.varun.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
			session.close();
		}
	}
}
