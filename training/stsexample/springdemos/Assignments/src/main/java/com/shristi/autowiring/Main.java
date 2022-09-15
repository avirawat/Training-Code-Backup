package com.shristi.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
	
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.autowiring");
		Performer performer=context.getBean("performer",Performer.class);
		performer.playSong("violin", "lalala");
		performer.playSong("piano", "hahahha");
		performer.playSong("guitar", "mamamma");
	}

}
