package com.shristi.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	@Autowired
	@Qualifier("violin")         //by type
	Instrument instrument;
	
	@Autowired                       
	Instrument ginstrument;      //by name
	
	@Autowired
	@Qualifier("piano")           // type
	Instrument pinstrument;
	
	
	
	
	void playSong(String type,String song) {
		System.out.println("Song type");
		if(type.equals("violin"))
			instrument.play(song);
		if(type.equals("guitar"))
			ginstrument.play(song);
		if(type.equals("piano"))
			pinstrument.play(song);
	}
}
