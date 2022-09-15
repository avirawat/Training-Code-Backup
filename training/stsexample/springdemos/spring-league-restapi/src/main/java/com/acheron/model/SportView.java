package com.acheron.model;

//retrieving data from a view
public interface SportView {
	// create getter method for columns in view
// column names should be in caps	
	
	String getSPORTSNAME();
	String getLEAGUENAME();
	String getDURATION();
	String getMEMBERCITY();
	String getSTADIUM();

}
