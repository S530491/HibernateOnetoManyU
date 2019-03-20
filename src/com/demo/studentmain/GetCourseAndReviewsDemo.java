package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {

	
//	get instructor from the db
	session.beginTransaction();
	
	
//	create some courses
	int i=10;
	Course t=session.get(Course.class,i);
	System.out.println(t);
	System.out.println(t.getReviews());
	
	
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	
	session.getTransaction().commit();
}finally {
	session.close();
	factory.close();
}
	}
}
