package com.shristi.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		ApplicationContext context= new AnnotationConfigApplicationContext("com.shristi.scope");
		
		Course course1=context.getBean(Course.class);
		System.out.println("course -1 "+course1.getCourseName());
		System.out.println("trainer-1" +course1.getTrainer().getTrainerName());
		
		Course course2=context.getBean(Course.class);
		System.out.println("course -2 "+course2.getCourseName());
		System.out.println("trainer-2" +course1.getTrainer().getTrainerName());
		
		course1.setCourseName("Angular");
		
		Trainer trainer=course1.getTrainer();
		trainer.setTrainerName("rahul");
		course1.setTrainer(trainer);
		
		System.out.println("course -1 "+course1.getCourseName());
		System.out.println("trainer-1" +course1.getTrainer().getTrainerName());
		
		System.out.println("course -2 "+course2.getCourseName());
		System.out.println("trainer-2" +course1.getTrainer().getTrainerName());
		
	}

}
