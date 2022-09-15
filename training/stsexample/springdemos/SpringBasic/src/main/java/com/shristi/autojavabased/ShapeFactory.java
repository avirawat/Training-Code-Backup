package com.shristi.autojavabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class ShapeFactory {
	@Autowired
	@Qualifier("srectangle")   // autowiring by type 
	Shape shape;
	
	@Autowired
	@Qualifier("striangle") 
	Shape striangle;        //autowiring by name
	
	@Autowired
	Shape myshape;
	
	public void setShape(Shape shape) {
		this.shape = shape;
	} 
	
	public void printArea(String choice,int x,int y) {
		System.out.println("Printing Area");
		if(choice.equals("r"))
		shape.area(10, 20);
		else if(choice.equals("t"))
			striangle.area(x, y);
		else if(choice.equals("s"))
		myshape.area(x, y);
	}

	
	
}
