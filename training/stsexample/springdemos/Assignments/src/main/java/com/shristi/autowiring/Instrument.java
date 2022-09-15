package com.shristi.autowiring;

import org.springframework.stereotype.Component;

@Component
public interface Instrument {
	
	void play(String song);
}
