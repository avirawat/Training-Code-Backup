package com.shristi.autojavabased;

import org.springframework.stereotype.Component;


public class Guitar implements Instrument {

	@Override
	public void play(String song) {
		System.out.println("Song name is"+song);
		
	}

}
