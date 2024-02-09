package com.example.jpaonetoonebi;

import com.example.jpaonetoonebi.dao.AppDAO;
import com.example.jpaonetoonebi.enitty.Instructor;
import com.example.jpaonetoonebi.enitty.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//		createInstructor(appDAO);
//		findInstructor(appDAO);
//		deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);

            deleteInstructorDetail(appDAO);

        };

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 6;
        appDAO.deleteInstructorDetailById(theId);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 6;
        InstructorDetail tempInstructorDetail =appDAO.findInstructorDetailById(theId);
    	Instructor tempInstructor = tempInstructorDetail.getInstructor();
        System.out.println("Instructor detail: "+ tempInstructorDetail	);
        System.out.println("Instructor : "+ tempInstructor);
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 5;
        appDAO.deleteInstructorById(theId);

    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 5;
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("instructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Chad", "Darby", "hehe@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.haha.com", "Reading book");
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        appDAO.save(tempInstructor);

    }
}
