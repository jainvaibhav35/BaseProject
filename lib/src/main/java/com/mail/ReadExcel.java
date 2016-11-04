package com.mail;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ReadExcel {

    int rowCount = 0, columnCount = 0;
    mailData mailDataObject;
    ArrayList<mailData> listMailData;

    /**
     * Method to get the mailDetails form Excel File
     *
     * @return
     * @throws IOException
     */
    public mailData getMailDetails() throws IOException {

        int position = 0;

        readExcel();

        if (listMailData != null && listMailData.size() > 0) {
            position = getRandomNumberInRange(1, listMailData.size() - 1);
            return listMailData.get(position);
        } else {
            return null;
        }

    }

    /**
     * Method to generate a random number between range min to max
     *
     * @param min -- min value of random number
     * @param max -- max value of random number
     * @return -- Generated Number
     */

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Method to read data from Excel file
     *
     * @throws IOException
     */

    public void readExcel() throws IOException {

        try {

            listMailData = new ArrayList<mailData>();

            File myFile = new File(getClass().getResource("/Data.xlsx").toURI());

            FileInputStream fis = new FileInputStream(myFile); // Finds the

            // workbook
            // instance for
            // XLSX
            // file

            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis); // Return first
            // sheet
            // from the XLSX
            // workbook

            XSSFSheet mySheet = myWorkBook.getSheetAt(0); // Get iterator to all
            // the
            // rows in current
            // sheet

            Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over
            // each
            // row of XLSX file
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                rowCount++;
                columnCount = 0;
                mailDataObject = new mailData();

                while (cellIterator.hasNext()) {

                    columnCount++;

                    Cell cell = cellIterator.next();
                    switch (columnCount) {

                        case 1:
                            mailDataObject.setMailTo(cell.getStringCellValue()
                                    + "");
                            break;
                        case 2:
                            mailDataObject.setSubject(cell.getStringCellValue()
                                    + "");
                            break;
                        case 3:
                            mailDataObject
                                    .setMessage(cell.getStringCellValue() + "");
                            break;
                        default:

                    }
                }
                listMailData.add(mailDataObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
