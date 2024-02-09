package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			deleteInstructorDetail(appDAO);
//		createInstructor(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		System.out.println("the associate instructor: "+ tempInstructorDetail.getInstructor());


	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =1;
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associate instructorDetail only: "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad","Darby","hehe@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.haha.com","Reading book");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// NOTE : this will ALSO save the detail object
		//becasue of CascadeType.ALL
		System.out.println("saving instructor"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");

	}
}
