package com.acheron.service;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class ExampleEventUserModel {
	
	Logger logger = LoggerFactory.getLogger(ExampleEventUserModel.class);
	
	public void processOneSheet(String filename) throws Exception {
		
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader( pkg );
        StylesTable styles = r.getStylesTable();
        SharedStringsTable sst = r.getSharedStringsTable();
        
        ContentHandler handler=new XSSFSheetXMLHandler(styles, sst, null, true);
		XMLReader parser = XMLReaderFactory.createXMLReader();
        // To look up the Sheet Name / Sheet Order / rID,
        //  you need to process the core Workbook stream.
        // Normally it's of the form rId# or rSheet#
		InputStream sheet2 = r.getSheet("rId31");
		//InputStream sheet2 = r.getSheet()
        InputSource sheetSource = new InputSource(sheet2);
		parser.setContentHandler(handler);
        parser.parse(sheetSource);
        sheet2.close();
    }
	
	 public void processAllSheets(String filename) throws Exception {
		 logger.info("Inside function");
	        OPCPackage pkg = OPCPackage.open(filename);
	        logger.info("Excel file open");
	        XSSFReader r = new XSSFReader( pkg );
	        logger.info("Reading Excel sheets");
	        SharedStringsTable sst = r.getSharedStringsTable();
	        XMLReader parser = XMLReaderFactory.createXMLReader();
	        logger.info("Using Iterator for all sheets");
	        Iterator<InputStream> sheets = r.getSheetsData();
	        logger.info("Loop");
	        while(sheets.hasNext()) {
	        	logger.info("Inside loop");
	            System.out.println("Processing new sheet:\n");
	            InputStream sheet = sheets.next();
	            InputSource sheetSource = new InputSource(sheet);
	            logger.info(sheetSource.getSystemId());
	            
	          parser.parse(sheetSource);
	            sheet.close();
	            System.out.println("");
	        }
	    }
//	 public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException, ParserConfigurationException {
//	        XMLReader parser = XMLHelper.newXMLReader();
//	        ContentHandler handler = new SheetHandler(sst);
//	        parser.setContentHandler(handler);
//	        return parser;
//	    }
//	 private static class SheetHandler extends DefaultHandler {
//	        private SharedStringsTable sst;
//	        private String lastContents;
//	        private boolean nextIsString;
//	        private SheetHandler(SharedStringsTable sst) {
//	            this.sst = sst;
//	        }
//	        public void startElement(String uri, String localName, String name,
//	                                 Attributes attributes) throws SAXException {
//	            // c => cell
//	            if(name.equals("c")) {
//	                // Print the cell reference
//	                System.out.print(attributes.getValue("r") + " - ");
//	                // Figure out if the value is an index in the SST
//	                String cellType = attributes.getValue("t");
//	                if(cellType != null && cellType.equals("s")) {
//	                    nextIsString = true;
//	                } else {
//	                    nextIsString = false;
//	                }
//	            }
//	            // Clear contents cache
//	            lastContents = "";
//	        }
//	        public void endElement(String uri, String localName, String name)
//	                throws SAXException {
//	            // Process the last contents as required.
//	            // Do now, as characters() may be called more than once
//	            if(nextIsString) {
//	                int idx = Integer.parseInt(lastContents);
//	                lastContents = sst.getItemAt(idx).getString();
//	                nextIsString = false;
//	            }
//	            // v => contents of a cell
//	            // Output after we've seen the string contents
//	            if(name.equals("v")) {
//	                System.out.println(lastContents);
//	            }
//	        }
//	        public void characters(char[] ch, int start, int length) {
//	            lastContents += new String(ch, start, length);
//	        }
//	    }

	

}
