package com.shristi.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	@Autowired
	@Qualifier("rectangle")   // autowiring by type 
	Shape shape;
	
	@Autowired
	Shape tshape;        //autowiring by name
	
	@Autowired
	@Qualifier("square")   // autowiring by type 
	Shape myshape;
	
	public void setShape(Shape shape) {
		this.shape = shape;
	} 
	
	public void printArea(String choice,int x,int y) {
		System.out.println("Printing Area");
		if(choice.equals("r"))
		shape.area(10, 20);
		else if(choice.equals("t"))
		tshape.area(x, y);
		else if(choice.equals("s"))
		myshape.area(x, y);
	}

	
	
}
