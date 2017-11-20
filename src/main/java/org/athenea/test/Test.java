package org.athenea.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.athenea.model.Course;
import org.athenea.repositories.CourseRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class Test {

	public void testUsingRepositories() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CourseRepository repository = (CourseRepository) context.getBean("courseRepository");
		repository.deleteAll();

		Course g1 = new Course("Ingenieria Informatica");
		Course g2 = new Course("Ingenieria Mecanica");

		Course g3 = new Course("Master en Medioambiente");
		g3.setProfesorEmail("unazuzu");
		ArrayList<String> tags = new ArrayList<>();
		tags.add("kappa");
		tags.add("yolo");
		g3.setTags(tags);
		g2.setTags(tags);

		repository.save(g1);
		repository.save(g2);
		repository.save(g3);

		// fetch grades
		System.out.println("\nGrades found with findAll():");
		System.out.println("-------------------------------");
		for (Course grade : repository.findAll()) {
			System.out.println(grade);
		}

		System.out.println("\nGrades found with findByNameLike('Ingenieria'):");
		System.out.println("--------------------------------");
		for (Course grade : repository.findByNameLike("Ingenieria")) {
			System.out.println(grade);
		}

		System.out.println("\nGrades found with findByProfesorEmail('unazuzu'):");
		System.out.println("--------------------------------");
		for (Course grade : repository.findByProfesorEmail("unazuzu")) {
			System.out.println(grade);
		}
		System.out.println("\nGrades found with findByTags('yolo'):");
		System.out.println("--------------------------------");
		for (Course grade : repository.findByTags("kappa")) {
			System.out.println(grade);
		}

	}

	public void printGradeDetails(Course g) {
		System.out.println(g);
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.testUsingRepositories();
	}

}
