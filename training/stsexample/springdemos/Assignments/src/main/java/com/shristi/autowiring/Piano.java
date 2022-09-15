package com.shristi.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {

	@Override
	public void play(String song) {
		System.out.println("Song name is"+song);
		
	}

}
