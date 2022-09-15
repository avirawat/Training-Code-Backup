package com.npd.service;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MigrationService {

	public void getAllDetails(FileInputStream inputStream) throws IOException {

		Logger logger = LoggerFactory.getLogger(MigrationService.class);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		logger.info("STore in WorkBook ");
		XSSFSheet sheet = workbook.getSheet("Data2");
		logger.info("Select Sheet in EXcel ");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		for (int r = 0; r <= 10; r++) {
			logger.info("inside Row");
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < 10; c++) {
				logger.info("inside columns");
				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
			}
			System.gc();
			System.out.println();
		}
	}
}
