package com.varun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.varun.hibernate.demo.entity.Instructor;
import com.varun.hibernate.demo.entity.InstructorDetail;
import com.varun.hibernate.demo.entity.Student;

public class CreateDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			Instructor tempInstructor = new Instructor("Varun", "Singh", "varun@gmail.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("http://www.varun.com","love to code");
			
			Instructor tempInstructor = new Instructor("Vinay", "Singh", "vinay@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.vinay.com","love to gym");
			
			tempInstructor.setInstructorDetail(instructorDetail);
			
			
			
			session.beginTransaction();
			
			System.out.println("Saving this: " + tempInstructor);
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
}
