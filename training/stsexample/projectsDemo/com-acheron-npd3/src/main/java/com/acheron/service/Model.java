package com.acheron.service;

import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.acheron.model.AllDataEntity;

import javax.xml.parsers.ParserConfigurationException;

public class Model {
	
	
	static Logger logger = LoggerFactory.getLogger(Model.class);
//	 public void processOneSheet(String filename) throws Exception {
//		 	
//	        OPCPackage pkg = OPCPackage.open(filename);
//	        XSSFReader r = new XSSFReader( pkg );
//	        SharedStringsTable sst = r.getSharedStringsTable();
//	        XMLReader parser = fetchSheetParser(sst);
//	        // To look up the Sheet Name / Sheet Order / rID,
//	        //  you need to process the core Workbook stream.
//	        // Normally it's of the form rId# or rSheet#
//	        InputStream sheet2 = r.getSheet("Data");
//	        InputSource sheetSource = new InputSource(sheet2);
//	        //parser.parse(sheetSource);
//	        sheet2.close();
//	    }
	    public void processAllSheets(String filename) throws Exception {
	    	logger.info("inside All Process function");
	        OPCPackage pkg = OPCPackage.open(filename);
	        logger.info("After Reading file");
	        XSSFReader r = new XSSFReader( pkg );
	        SharedStringsTable sst = r.getSharedStringsTable();
	        logger.info("printing data");
	        XMLReader parser = fetchSheetParser(sst);
	        logger.info("Iterator Data");
	        Iterator<InputStream> sheets = r.getSheetsData();
	        int count=1;
	        while(sheets.hasNext()) {
	        	if(count==1) {
		            System.out.println("Processing new sheet:\n "+ count);
		            InputStream sheet = sheets.next();
		           
		            InputSource sheetSource = new InputSource(sheet);
		            parser.parse(sheetSource);
		         //   parser.getProperty("Id");
		            sheet.close();
		            System.out.println("####");
		            
	        	}
	        	count++;
	        }
	    }
	    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException, ParserConfigurationException {
	    	 logger.info("Shared Sheet Parser");
	        XMLReader parser = XMLHelper.newXMLReader();
	        ContentHandler handler = new SheetHandler(sst);
	        parser.setContentHandler(handler);
	        return parser;
	    }
	    /**
	     * See org.xml.sax.helpers.DefaultHandler javadocs
	     */
	    private static class SheetHandler extends DefaultHandler {
	    	
	        private SharedStringsTable sst;
	        private String lastContents;
	        private String columnName;
	        private boolean nextIsString;
	        private SheetHandler(SharedStringsTable sst) {
	        	 logger.info("Sheet Handler");
	            this.sst = sst;
	        }
	        public void startElement(String uri, String localName, String name,
	                                 Attributes attributes) throws SAXException {
	        	
	            // c => cell
	            if(name.equals("c")) {
	                // Print the cell reference
	                columnName=attributes.getValue("r");
	                // Figure out if the value is an index in the SST
	                String cellType = attributes.getValue("t");
	                
	                if(cellType != null && cellType.equals("s")) {
	                    nextIsString = true;
	                } else {
	                    nextIsString = false;
	                }
	            }
	            // Clear contents cache
	            lastContents = "";
	        }
	        public void endElement(String uri, String localName, String name)
	                throws SAXException {
	            // Process the last contents as required.
	            // Do now, as characters() may be called more than once
	        	
	        	AllDataEntity allData=new AllDataEntity();
	        	
	            if(nextIsString) {
	                int idx = Integer.parseInt(lastContents);
	                logger.info("Index "+idx);
	                lastContents = sst.getItemAt(idx).getString();
	                logger.info("Last content "+lastContents);
	                nextIsString = false;
	            }
	            // v => contents of a cell
	            // Output after we've seen the string contents
	            if(name.equals("v")) {
	            	//Attributes attributes
	            	logger.info(uri);
	                System.out.println(lastContents);
	            }
	            
	        }
	        public void characters(char[] ch, int start, int length) {
	            lastContents += new String(ch, start, length);
	        }
	    }

}
