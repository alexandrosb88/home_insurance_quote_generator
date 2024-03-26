package Home_Insurance_Quote_Generator;

/*

This class contains several print statements intended for checking and debugging.
Uncomment them to use.

 */

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook; // for .xls files - HSSFWorkbook must be included
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // for .ods file - XSSFWorkbook must be included

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EXCEL_COPY {

    public static void generateEXCEL(String homeInput, String contentInput, String broker, String name, String VAT, String email,
                                     String address, String postalCode, ComboBox residenceType, String description,
                                     CheckBox box5, CheckBox box6, CheckBox box7, CheckBox box8, CheckBox box9, CheckBox box10,
                                     CheckBox box11, CheckBox box12, CheckBox box13, CheckBox box14, CheckBox box15, CheckBox box16,
                                     CheckBox box17, CheckBox box18, CheckBox box19, CheckBox box20, CheckBox box21, CheckBox box22,
                                     CheckBox box23, CheckBox box24, CheckBox box25, CheckBox box26, CheckBox box27, CheckBox box28,
                                     CheckBox box29, CheckBox box30,

                                     String b5Value, String b12Value,

                                     String c5Value, String c12Value,

                                     String s5Value, String s12Value, String s13Value, String s14Value,
                                     String s15Value,

                                     ComboBox<String> earthquake, String dfield1Value, String dfield2Value, String dfield3Value,
                                     String dfield4Value,

                                     String underinsurance, String theftMeasures, String premium, ComboBox<String> underwriters,

                                     List<String> agreementList, List<String> requirementList

                                     ) {


        // File path
        String inputFilePath = "home_insurance_source_file.xls";
        String outputFilePath = "home_insurance_output_file.xls";
        String sheetName = "sheet1";

        Map<Integer, Integer> rowMapping = new HashMap<>();

        int homeCapital = Integer.parseInt(homeInput);
        int contentCapital = Integer.parseInt(contentInput);
        int sumCapital = homeCapital + contentCapital;
        

        try {
            FileInputStream fileInputStream = new FileInputStream(inputFilePath);
            Workbook inputWorkbook = new HSSFWorkbook(fileInputStream);
            Sheet inputSheet = inputWorkbook.getSheet(sheetName);

            // Create a new workbook for the output
            Workbook outputWorkbook = new HSSFWorkbook();
            Sheet outputSheet = outputWorkbook.createSheet(sheetName);

            // Create a list to store rows to be excluded and included
            List<Integer> rowsToExclude = new ArrayList<>();
            List<Integer> rowsToInclude = new ArrayList<>();

            int lastRowNum = inputSheet.getLastRowNum();
            System.out.println(lastRowNum);



            // ----- GETTING THE ROWS -----


            for (int i = 0; i <= 28; i++) {
                rowsToInclude.add(i);
            }

            for (int i = 40; i <= 42; i++) {
                rowsToInclude.add(i);
            }

            rowsToInclude.add(48);
            rowsToInclude.add(49);

            rowsToInclude.add(53);
            rowsToInclude.add(54);

            rowsToInclude.add(58);
            rowsToInclude.add(59);


            for (int i = 64; i <= 74; i++) {
                rowsToInclude.add(i);
            }


            // --- Covers ---

            // Firefighting & debris removal

            if (box5.isSelected()) {
                rowsToInclude.add(29);
            } else {
                rowsToExclude.add(29);
            }

            // Weather conditions

            if (box6.isSelected()) {
                rowsToInclude.add(30);
            } else {
                rowsToExclude.add(30);
            }

            // Water damage

            if (box7.isSelected()) {
                rowsToInclude.add(31);
            } else {
                rowsToExclude.add(31);
            }

            // Earthquake

            if (box8.isSelected()) {
                rowsToInclude.add(32);
            } else {
                rowsToExclude.add(32);
            }

            // Terrorist Attack

            if (box9.isSelected()) {
                rowsToInclude.add(33);
            } else {
                rowsToExclude.add(33);
            }

            // Malicious acts

            if (box10.isSelected()) {
                rowsToInclude.add(34);
            } else {
                rowsToExclude.add(34);
            }

            // Theft of content

            if (box11.isSelected()) {
                rowsToInclude.add(35);
            } else {
                rowsToExclude.add(35);
            }

            // Short circuit

            if (box12.isSelected()) {
                rowsToInclude.add(36);
            } else {
                rowsToExclude.add(36);
            }

            // Third-party liability

            if (box13.isSelected()) {
                rowsToInclude.add(37);
            } else {
                rowsToExclude.add(37);
            }

            // Legal expenses

            if (box14.isSelected()) {
                rowsToInclude.add(38);
            } else {
                rowsToExclude.add(38);
            }

            // All risk

            if (box15.isSelected()) {
                rowsToInclude.add(39);
            } else {
                rowsToExclude.add(39);
            }



            // --- Deductibles ---

            if (box16.isSelected()) {
                rowsToInclude.add(43);
            } else {
                rowsToExclude.add(43);
            }

            if (box17.isSelected()) {
                rowsToInclude.add(44);
            } else {
                rowsToExclude.add(44);
            }

            if (box18.isSelected()) {
                rowsToInclude.add(45);
            } else {
                rowsToExclude.add(45);
            }

            if (box19.isSelected()) {
                rowsToInclude.add(46);
            } else {
                rowsToExclude.add(46);
            }

            if (box20.isSelected()) {
                rowsToInclude.add(47);
            } else {
                rowsToExclude.add(47);
            }



            // --- General exclusions ---

            if (box21.isSelected()) {
                rowsToInclude.add(50);
            } else {
                rowsToExclude.add(50);
            }

            if (box22.isSelected()) {
                rowsToInclude.add(51);
            } else {
                rowsToExclude.add(51);
            }

            if (box23.isSelected()) {
                rowsToInclude.add(52);
            } else {
                rowsToExclude.add(52);
            }


            // --- Special agreements ---

            if (box24.isSelected()) {
                rowsToInclude.add(55);
            } else {
                rowsToExclude.add(55);
            }

            if (box25.isSelected()) {
                rowsToInclude.add(56);
            } else {
                rowsToExclude.add(56);
            }

            if (box26.isSelected()) {
                rowsToInclude.add(57);
            } else {
                rowsToExclude.add(57);
            }


            // --- Conditions & special exclusions ---

            if (box27.isSelected()) {
                rowsToInclude.add(60);
            } else {
                rowsToExclude.add(60);
            }

            if (box28.isSelected()) {
                rowsToInclude.add(61);
            } else {
                rowsToExclude.add(61);
            }

            if (box29.isSelected()) {
                rowsToInclude.add(62);
            } else {
                rowsToExclude.add(62);
            }

            if (box30.isSelected()) {
                rowsToInclude.add(63);
            } else {
                rowsToExclude.add(63);
            }


            // Iterate over all rows

            int rowExcludedCounter = 0;

            for (int i = 0; i <= lastRowNum; i++) {


                // Check if the row should be excluded
                if (rowsToExclude.contains(i)) {
                    rowExcludedCounter++;
                    //System.out.println("exluded counter: " + rowExcludedCounter);
                    continue;
                }

                // Check if the row should be included
                if (rowsToInclude.contains(i)) {

                    Row inputRow = inputSheet.getRow(i);
                    //System.out.println("getting row " + i + " from source");

                    int newRow = i - rowExcludedCounter;
                    rowMapping.put(i, newRow);

                    if (rowExcludedCounter != 0) {

                        Row outputRow = outputSheet.createRow(i - rowExcludedCounter);
                        outputRow.setHeight(inputRow.getHeight());
                        //System.out.println("row height: " + inputRow.getHeight());
                        //System.out.println("creating row " + (i - rowExcludedCounter) + " in output");


                        for (int colNum = 0; colNum < inputRow.getLastCellNum(); colNum++) {

                            Cell inputCell = inputRow.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            Cell outputCell = outputRow.createCell(colNum);
                            outputSheet.setColumnWidth(colNum, inputSheet.getColumnWidth(colNum));

                            // Copy cell value, formatting, and font
                            copyCell(inputCell, outputCell, outputWorkbook);
                        }

                        for (int counterMerged = 0; counterMerged < inputSheet.getNumMergedRegions(); counterMerged++) {

                            CellRangeAddress mergedRegion = inputSheet.getMergedRegion(counterMerged);
                            //System.out.println("Got region : " + inputSheet.getMergedRegion(counterMerged));

                            if (mergedRegion.isInRange(i, mergedRegion.getFirstColumn())) {

                                CellRangeAddress newMergedRegion = new CellRangeAddress(
                                        mergedRegion.getFirstRow() - rowExcludedCounter,
                                        mergedRegion.getLastRow() - rowExcludedCounter,
                                        mergedRegion.getFirstColumn(),
                                        mergedRegion.getLastColumn());
                                //System.out.println("Subtract " + rowExcludedCounter + " from " + mergedRegion.getFirstRow());

                                outputSheet.addMergedRegion(newMergedRegion);
                                //System.out.println("New merged region: " + newMergedRegion);
                                //System.out.println("adding new merged region");

                            }
                        }
                    }

                    else {

                            Row outputRow = outputSheet.createRow(i - rowExcludedCounter);
                            outputRow.setHeight(inputRow.getHeight());
                            //System.out.println("creating row " + i + " in output");


                            for (int colNum = 0; colNum < inputRow.getLastCellNum(); colNum++) {
                                Cell inputCell = inputRow.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                Cell outputCell = outputRow.createCell(colNum);
                                outputSheet.setColumnWidth(colNum, inputSheet.getColumnWidth(colNum));

                                // Copy cell value, formatting, and font
                                copyCell(inputCell, outputCell, outputWorkbook);
                            }

                            for (int counterMerged = 0; counterMerged < inputSheet.getNumMergedRegions(); counterMerged++) {

                                CellRangeAddress mergedRegion = inputSheet.getMergedRegion(counterMerged);
                                //System.out.println("Got region : " + inputSheet.getMergedRegion(counterMerged));

                                if (mergedRegion.isInRange(i, mergedRegion.getFirstColumn())) {

                                    CellRangeAddress newMergedRegion = new CellRangeAddress(
                                            mergedRegion.getFirstRow(),
                                            mergedRegion.getLastRow(),
                                            mergedRegion.getFirstColumn(),
                                            mergedRegion.getLastColumn());

                                    outputSheet.addMergedRegion(newMergedRegion);
                                    //System.out.println("New merged region: " + newMergedRegion);
                                    //System.out.println("adding new merged region");

                                }
                            }

                            }
                        }

                }



                //System.out.println("Rows to Include: " + rowsToInclude);
                //System.out.println("Rows to Exclude: " + rowsToExclude);



            // ----- SETTING THE VALUES -----

            // --- General Info ---

            Row row4 = outputSheet.getRow(3);
            Cell brokerInputField = row4.getCell(1);
            brokerInputField.setCellValue(broker);

            Row row10 = outputSheet.getRow(9);
            Cell nameInputField = row10.getCell(1);
            nameInputField.setCellValue(name);

            Row row11 = outputSheet.getRow(10);
            Cell VATInputField = row11.getCell(1);
            VATInputField.setCellValue(VAT);

            Row row13 = outputSheet.getRow(12);
            Cell emailInputField = row13.getCell(1);
            emailInputField.setCellValue(email);

            Row row14 = outputSheet.getRow(13);
            Cell addressInputField = row14.getCell(1);
            addressInputField.setCellValue(address + ", P.C. " + postalCode);

            Row row15 = outputSheet.getRow(14);
            Cell residenceTypeInputField = row15.getCell(1);
            String residenceTypeValue = (String) residenceType.getValue();
            residenceTypeInputField.setCellValue(residenceTypeValue);

            Row row16 = outputSheet.getRow(15);
            Cell descriptionInputField = row16.getCell(1);
            descriptionInputField.setCellValue(description);


            // Home input

            Row row20 = outputSheet.getRow(19);
            Cell homeInputField = row20.createCell(1);
            copyCellFormat(inputSheet.getRow(19).getCell(1), homeInputField, outputWorkbook);
            homeInputField.setCellValue(homeCapital);


            // Content input

            Row row21 = outputSheet.getRow(20);
            Cell contentInputField = row21.createCell(1);
            copyCellFormat(inputSheet.getRow(20).getCell(1), contentInputField, outputWorkbook);
            contentInputField.setCellValue(contentCapital);


            // Sum input

            Row row22 = outputSheet.getRow(21);
            Cell sumField = row22.createCell(1);
            copyCellFormat(inputSheet.getRow(21).getCell(1), sumField, outputWorkbook);
            sumField.setCellValue(sumCapital);


            // --- Covers ---

            // Flexa

            Row row26 = outputSheet.getRow(25);
            Cell bfield1 = row26.createCell(1);
            Cell cfield1 = row26.createCell(2);
            Cell sfield1 = row26.createCell(3);

            copyCellFormat(inputSheet.getRow(25).getCell(1), bfield1, outputWorkbook);
            copyCellFormat(inputSheet.getRow(25).getCell(2), cfield1, outputWorkbook);
            copyCellFormat(inputSheet.getRow(25).getCell(3), sfield1, outputWorkbook);

            bfield1.setCellValue(homeCapital);
            cfield1.setCellValue(contentCapital);
            sfield1.setCellValue(sumCapital);

            Row row27 = outputSheet.getRow(26);
            Cell bfield2 = row27.createCell(1);
            Cell cfield2 = row27.createCell(2);
            Cell sfield2 = row27.createCell(3);

            copyCellFormat(inputSheet.getRow(26).getCell(1), bfield2, outputWorkbook);
            copyCellFormat(inputSheet.getRow(26).getCell(2), cfield2, outputWorkbook);
            copyCellFormat(inputSheet.getRow(26).getCell(3), sfield2, outputWorkbook);

            bfield2.setCellValue(homeCapital);
            cfield2.setCellValue(contentCapital);
            sfield2.setCellValue(sumCapital);

            Row row28 = outputSheet.getRow(27);
            Cell bfield3 = row28.createCell(1);
            Cell cfield3 = row28.createCell(2);
            Cell sfield3 = row28.createCell(3);

            copyCellFormat(inputSheet.getRow(27).getCell(1), bfield3, outputWorkbook);
            copyCellFormat(inputSheet.getRow(27).getCell(2), cfield3, outputWorkbook);
            copyCellFormat(inputSheet.getRow(27).getCell(3), sfield3, outputWorkbook);

            bfield3.setCellValue(homeCapital);
            cfield3.setCellValue(contentCapital);
            sfield3.setCellValue(sumCapital);

            Row row29 = outputSheet.getRow(28);
            Cell bfield4 = row29.createCell(1);
            Cell cfield4 = row29.createCell(2);
            Cell sfield4 = row29.createCell(3);

            copyCellFormat(inputSheet.getRow(28).getCell(1), bfield4, outputWorkbook);
            copyCellFormat(inputSheet.getRow(28).getCell(2), cfield4, outputWorkbook);
            copyCellFormat(inputSheet.getRow(28).getCell(3), sfield4, outputWorkbook);

            bfield4.setCellValue(homeCapital);
            cfield4.setCellValue(contentCapital);
            sfield4.setCellValue(sumCapital);

            // TEST ROW MAPPING

            //System.out.println("rowMapping: " + rowMapping);


            // Firefighting & debris removal

            if (box5.isSelected()) {

                int b5newValue = convertInputValueToInt(b5Value);
                int c5newValue = convertInputValueToInt(c5Value);
                int s5newValue = convertInputValueToInt(s5Value);

                int newRow = rowMapping.get(29);
                Row row30 = outputSheet.getRow(newRow);
                Cell bfield5 = row30.createCell(1);
                Cell cfield5 = row30.createCell(2);
                Cell sfield5 = row30.createCell(3);

                copyCellFormat(inputSheet.getRow(29).getCell(1), bfield5, outputWorkbook);
                copyCellFormat(inputSheet.getRow(29).getCell(2), cfield5, outputWorkbook);
                copyCellFormat(inputSheet.getRow(29).getCell(3), sfield5, outputWorkbook);

                bfield5.setCellValue(b5newValue);
                cfield5.setCellValue(c5newValue);
                sfield5.setCellValue(s5newValue);
            }


            // Weather conditions

            if (box6.isSelected()) {

                int newRow = rowMapping.get(30);
                Row row31 = outputSheet.getRow(newRow);


                Cell bfield6 = row31.createCell(1);
                Cell cfield6 = row31.createCell(2);
                Cell sfield6 = row31.createCell(3);

                copyCellFormat(inputSheet.getRow(30).getCell(1), bfield6, outputWorkbook);
                copyCellFormat(inputSheet.getRow(30).getCell(2), cfield6, outputWorkbook);
                copyCellFormat(inputSheet.getRow(30).getCell(3), sfield6, outputWorkbook);

                bfield6.setCellValue(homeCapital);
                cfield6.setCellValue(contentCapital);
                sfield6.setCellValue(sumCapital);
            }

            // Water damage

            if (box7.isSelected()) {


                int newRow = rowMapping.get(31);
                Row row32 = outputSheet.getRow(newRow);


                Cell bfield7 = row32.createCell(1);
                Cell cfield7 = row32.createCell(2);
                Cell sfield7 = row32.createCell(3);

                copyCellFormat(inputSheet.getRow(31).getCell(1), bfield7, outputWorkbook);
                copyCellFormat(inputSheet.getRow(31).getCell(2), cfield7, outputWorkbook);
                copyCellFormat(inputSheet.getRow(31).getCell(3), sfield7, outputWorkbook);

                bfield7.setCellValue(homeCapital);
                cfield7.setCellValue(contentCapital);
                sfield7.setCellValue(sumCapital);
            }

            // Earthquake

            if (box8.isSelected()) {
                
                int newRow = rowMapping.get(32);
                Row row33 = outputSheet.getRow(newRow);


                Cell bfield8 = row33.createCell(1);
                Cell cfield8 = row33.createCell(2);
                Cell sfield8 = row33.createCell(3);

                copyCellFormat(inputSheet.getRow(32).getCell(1), bfield8, outputWorkbook);
                copyCellFormat(inputSheet.getRow(32).getCell(2), cfield8, outputWorkbook);
                copyCellFormat(inputSheet.getRow(32).getCell(3), sfield8, outputWorkbook);

                bfield8.setCellValue(homeCapital);
                cfield8.setCellValue(contentCapital);
                sfield8.setCellValue(sumCapital);
            }


            // Terrorist Attack

            if (box9.isSelected()) {

                int newRow = rowMapping.get(33);
                Row row34 = outputSheet.getRow(newRow);


                Cell bfield9 = row34.createCell(1);
                Cell cfield9 = row34.createCell(2);
                Cell sfield9 = row34.createCell(3);

                copyCellFormat(inputSheet.getRow(33).getCell(1), bfield9, outputWorkbook);
                copyCellFormat(inputSheet.getRow(33).getCell(2), cfield9, outputWorkbook);
                copyCellFormat(inputSheet.getRow(33).getCell(3), sfield9, outputWorkbook);

                bfield9.setCellValue(homeCapital);
                cfield9.setCellValue(contentCapital);
                sfield9.setCellValue(sumCapital);
            }

            // Malicious acts

            if (box10.isSelected()) {

                int newRow = rowMapping.get(35);
                Row row35 = outputSheet.getRow(newRow);


                Cell bfield10 = row35.createCell(1);
                Cell cfield10 = row35.createCell(2);
                Cell sfield10 = row35.createCell(3);

                copyCellFormat(inputSheet.getRow(35).getCell(1), bfield10, outputWorkbook);
                copyCellFormat(inputSheet.getRow(35).getCell(2), cfield10, outputWorkbook);
                copyCellFormat(inputSheet.getRow(35).getCell(3), sfield10, outputWorkbook);

                bfield10.setCellValue(homeCapital);
                cfield10.setCellValue(contentCapital);
                sfield10.setCellValue(sumCapital);
            }

            // Theft of content

            if (box11.isSelected()) {

                int newRow = rowMapping.get(35);
                Row row36 = outputSheet.getRow(newRow);
                Cell bfield11 = row36.createCell(1);
                Cell cfield11 = row36.createCell(2);
                Cell sfield11 = row36.createCell(3);

                copyCellFormat(inputSheet.getRow(35).getCell(1), bfield11, outputWorkbook);
                copyCellFormat(inputSheet.getRow(35).getCell(2), cfield11, outputWorkbook);
                copyCellFormat(inputSheet.getRow(35).getCell(3), sfield11, outputWorkbook);

                bfield11.setCellValue("-");
                cfield11.setCellValue(contentCapital);
                sfield11.setCellValue(contentCapital);
            }


            // Short circuit
            
            if (box12.isSelected()) {

                int b12newValue = convertInputValueToInt(b12Value);
                int c12newValue = convertInputValueToInt(c12Value);
                int s12newValue = convertInputValueToInt(s12Value);

                int newRow = rowMapping.get(36);
                Row row37 = outputSheet.getRow(newRow);
                Cell bfield12 = row37.createCell(1);
                Cell cfield12 = row37.createCell(2);
                Cell sfield12 = row37.createCell(3);

                copyCellFormat(inputSheet.getRow(36).getCell(1), bfield12, outputWorkbook);
                copyCellFormat(inputSheet.getRow(36).getCell(2), cfield12, outputWorkbook);
                copyCellFormat(inputSheet.getRow(36).getCell(3), sfield12, outputWorkbook);

                bfield12.setCellValue(b12newValue);
                cfield12.setCellValue(c12newValue);
                sfield12.setCellValue(s12newValue);
            }


            // Third-party liability

            if (box13.isSelected()) {

                int s13newValue = convertInputValueToInt(s13Value);
                
                int newRow = rowMapping.get(37);
                Row row38 = outputSheet.getRow(newRow);
                Cell bfield13 = row38.createCell(1);
                Cell cfield13 = row38.createCell(2);
                Cell sfield13 = row38.createCell(3);

                copyCellFormat(inputSheet.getRow(37).getCell(1), bfield13, outputWorkbook);
                copyCellFormat(inputSheet.getRow(37).getCell(2), cfield13, outputWorkbook);
                copyCellFormat(inputSheet.getRow(37).getCell(3), sfield13, outputWorkbook);

                bfield13.setCellValue("-");
                cfield13.setCellValue("-");
                sfield13.setCellValue(s13newValue);
            }


            // Legal expenses

            if (box14.isSelected()) {

                int s14newValue = convertInputValueToInt(s14Value);

                int newRow = rowMapping.get(38);
                Row row39 = outputSheet.getRow(newRow);
                Cell bfield14 = row39.createCell(1);
                Cell cfield14 = row39.createCell(2);
                Cell sfield14 = row39.createCell(3);

                copyCellFormat(inputSheet.getRow(38).getCell(1), bfield14, outputWorkbook);
                copyCellFormat(inputSheet.getRow(38).getCell(2), cfield14, outputWorkbook);
                copyCellFormat(inputSheet.getRow(38).getCell(3), sfield14, outputWorkbook);

                bfield14.setCellValue("-");
                cfield14.setCellValue("-");
                sfield14.setCellValue(s14newValue);
            }

            // All risk

            if (box15.isSelected()) {

                int s15newValue = convertInputValueToInt(s15Value);

                int newRow = rowMapping.get(39);
                Row row40 = outputSheet.getRow(newRow);
                Cell bfield15 = row40.createCell(1);
                Cell cfield15 = row40.createCell(2);
                Cell sfield15 = row40.createCell(3);

                copyCellFormat(inputSheet.getRow(39).getCell(1), bfield15, outputWorkbook);
                copyCellFormat(inputSheet.getRow(39).getCell(2), cfield15, outputWorkbook);
                copyCellFormat(inputSheet.getRow(39).getCell(3), sfield15, outputWorkbook);

                bfield15.setCellValue("-");
                cfield15.setCellValue("-");
                sfield15.setCellValue(s15newValue);
            }


            // --- Deductibles ---

            // Earthquake

            if (box16.isSelected()) {

                String dfieldEartquakeValue = String.valueOf(earthquake.getValue());

                int newRowEarthquake = rowMapping.get(43);

                Row row44 = outputSheet.getRow(newRowEarthquake);
                Cell deductFieldEarthquake = row44.createCell(2);

                copyCellFormat(inputSheet.getRow(43).getCell(2), deductFieldEarthquake, outputWorkbook);
                

                deductFieldEarthquake.setCellValue(dfieldEartquakeValue);

            }


            // Weather conditions

            if (box17.isSelected()) {

                int newRowWeather = rowMapping.get(44);

                Row row45 = outputSheet.getRow(newRowWeather);
                Cell deductField1 = row45.createCell(2);

                copyCellFormat(inputSheet.getRow(44).getCell(2), deductField1, outputWorkbook);

                deductField1.setCellValue(dfield1Value);

            }


            // Water damage

            if (box18.isSelected()) {

                int newRowWater = rowMapping.get(45);

                Row row46 = outputSheet.getRow(newRowWater);
                Cell deductField2 = row46.createCell(2);

                copyCellFormat(inputSheet.getRow(45).getCell(2), deductField2, outputWorkbook);

                deductField2.setCellValue(dfield2Value);

            }


            // Theft of content

            if (box19.isSelected()) {

                int newRowTheft = rowMapping.get(46);

                Row row47 = outputSheet.getRow(newRowTheft);
                Cell deductField3 = row47.createCell(2);

                copyCellFormat(inputSheet.getRow(46).getCell(2), deductField3, outputWorkbook);

                deductField3.setCellValue(dfield3Value);

            }


            // Short circuit

            if (box20.isSelected()) {

                int newRowCircuit = rowMapping.get(47);

                Row row48 = outputSheet.getRow(newRowCircuit);
                Cell deductField4 = row48.createCell(2);

                copyCellFormat(inputSheet.getRow(47).getCell(2), deductField4, outputWorkbook);

                deductField4.setCellValue(dfield4Value);

            }


            

            // Zero Deductibles

            if ((!box16.isSelected() || box16 == null)  && (!box17.isSelected() || box17 == null) && (!box18.isSelected() || box18 == null) &&
                (!box19.isSelected() || box19 == null) && (!box20.isSelected() || box20 == null))
                  {

                int rowZeroDeductibles = rowMapping.get(42) + 1;
                Row newRowZeroDeductibles = outputSheet.createRow(rowZeroDeductibles);
                newRowZeroDeductibles.setHeight((short) 900);

                Cell ZeroDeductiblesField = newRowZeroDeductibles.createCell(0);
                copyCellFormat(inputSheet.getRow(50).getCell(0), ZeroDeductiblesField, outputWorkbook);
                ZeroDeductiblesField.setCellValue("No deductibles");
            }


            // --- AGREEMENTS EXCLUSIONS ETC. ---


            // Underinsurance protection clause

            if (box25.isSelected()) {

                int newRowUnderinsurance = rowMapping.get(56);

                Row row57 = outputSheet.getRow(newRowUnderinsurance);
                Cell underinsuranceField = row57.createCell(0);

                copyCellFormat(inputSheet.getRow(56).getCell(0), underinsuranceField, outputWorkbook);

                underinsuranceField.setCellValue("• Underinsurance protection clause " + underinsurance);

            }


            // Theft prevention measures

            if (box29.isSelected()) {

                int newRowTheftMeasures = rowMapping.get(62);

                Row row63 = outputSheet.getRow(newRowTheftMeasures);
                Cell theftMeasuresField = row63.createCell(0);

                copyCellFormat(inputSheet.getRow(62).getCell(0), theftMeasuresField, outputWorkbook);

                theftMeasuresField.setCellValue("• Theft prevention measures:" + theftMeasures);

            }


            // Premium

            int newRowPremium = rowMapping.get(66);

            Row row67 = outputSheet.getRow(newRowPremium);
            Cell premiumField = row67.createCell(1);

            copyCellFormat(inputSheet.getRow(66).getCell(1), premiumField, outputWorkbook);

            premiumField.setCellValue(premium);


            // Underwriter

            String underwriter = String.valueOf(underwriters.getValue());

            int newRowUnderwriters = rowMapping.get(72);

            Row row73 = outputSheet.getRow(newRowUnderwriters);
            Cell underwriterField = row73.createCell(0);

            copyCellFormat(inputSheet.getRow(72).getCell(0), underwriterField, outputWorkbook);

            underwriterField.setCellValue(underwriter);


            // Special agreements

            int initialPosition = 0;
            //System.out.println("initial Position = " + initialPosition);

            if (agreementList != null) {


                int baseRow = rowMapping.get(54);

                outputSheet.shiftRows(baseRow + 1, outputSheet.getLastRowNum(), agreementList.size(), true, false);
                //System.out.println("base row for agreement: " + baseRow);

                for (int i = 0; i < agreementList.size(); i++) {

                    baseRow = rowMapping.get(54) + initialPosition;
                    Row rowAgreement = outputSheet.createRow(baseRow + 1);
                    Cell newAgreementCell = rowAgreement.createCell(0);
                    copyCellFormat(inputSheet.getRow(55).getCell(0), newAgreementCell, outputWorkbook);
                    newAgreementCell.setCellValue(agreementList.get(i));

                    rowAgreement.setHeight((short) 900);

                    CellRangeAddress mergedRegion = new CellRangeAddress(
                            newAgreementCell.getRowIndex(), newAgreementCell.getRowIndex(),
                            newAgreementCell.getColumnIndex(), newAgreementCell.getColumnIndex() + 6
                    );

                    outputSheet.addMergedRegion(mergedRegion);


                    initialPosition++;

                }
            }


            // Requirements

            //System.out.println("initial Position before the requirement check: " + initialPosition);

            if (requirementList != null) {

                //int initialPosition = 0;
                int baseRow = rowMapping.get(59) + initialPosition;

                outputSheet.shiftRows(baseRow + 1, outputSheet.getLastRowNum(), requirementList.size(), true, false);
                //System.out.println("base row for requirement: " + baseRow);

                for (int i = 0; i < requirementList.size(); i++) {

                    baseRow = rowMapping.get(59) + initialPosition;
                    Row rowRequirement = outputSheet.createRow(baseRow + 1);
                    Cell newRequirementCell = rowRequirement.createCell(0);
                    copyCellFormat(inputSheet.getRow(60).getCell(0), newRequirementCell, outputWorkbook);
                    newRequirementCell.setCellValue(requirementList.get(i));

                    rowRequirement.setHeight((short) 900);

                    CellRangeAddress mergedRegion = new CellRangeAddress(
                            newRequirementCell.getRowIndex(), newRequirementCell.getRowIndex(),
                            newRequirementCell.getColumnIndex(), newRequirementCell.getColumnIndex() + 6
                    );

                    outputSheet.addMergedRegion(mergedRegion);


                    initialPosition++;

                }
            }



            // Images


            String imagePath1 = "C:\\Users\\Sonic\\IdeaProjects\\home_insurance_quote_generator\\src\\Home_Insurance_Quote_Generator\\company_logo.png";

            // Load the images
            InputStream image1 = new FileInputStream(imagePath1);

            byte[] bytes1 = IOUtils.toByteArray(image1);

            int pictureIdx1 = outputWorkbook.addPicture(bytes1, outputWorkbook.PICTURE_TYPE_JPEG);

            // Create a Drawing patriarch
            Drawing<?> drawing = outputSheet.createDrawingPatriarch();

            // Picture A

            int colA = 0; // column where you want to insert the image
            int rowA = 0; // row where you want to insert the image
            int dx1A = 0; // the x coordinate within the first cell
            int dy1A = 0; // the y coordinate within the first cell

            int col2A = colA + 2; // set col2 to the ending column (col + number of columns - 1)
            int row2A = rowA; // set row2 to the same row to span horizontally

            int dx2A = 1000; // the width of the image in EMU
            int dy2A = 250;    // the height of the image in EMU

            ClientAnchor anchorA = drawing.createAnchor(dx1A, dy1A, dx2A, dy2A, colA, rowA, col2A, row2A);


            // Create the picture and link it to the top-left cell
            Picture pictureA = drawing.createPicture(anchorA, pictureIdx1);


            inputSheet.setColumnBreak(inputSheet.getLastRowNum() + 1);

            // Save the changes back to the output file
                FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
                outputWorkbook.write(fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();


                //System.out.println("Output file created successfully!");
                Home_Insurance_Quote_Generator.alertMessage.displayConfirmationMessage("Quote generated successfully!");

                } catch(IOException e){
                    e.printStackTrace();
                    alertMessage.displayAlertMessage("An error occured");
                }
            }





    private static void copyCell(Cell sourceCell, Cell targetCell, Workbook workbook) {
        // Copy cell value
        setCellValue(targetCell, sourceCell);

        // Copy cell style
        CellStyle sourceCellStyle = sourceCell.getCellStyle();
        CellStyle targetCellStyle = workbook.createCellStyle();
        targetCellStyle.cloneStyleFrom(sourceCellStyle);
        targetCell.setCellStyle(targetCellStyle);
    }

    private static void setCellValue(Cell targetCell, Cell sourceCell) {
        switch (sourceCell.getCellType()) {
            case STRING:
                targetCell.setCellValue(sourceCell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(sourceCell)) {
                    targetCell.setCellValue(sourceCell.getDateCellValue());
                } else {
                    targetCell.setCellValue(sourceCell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                targetCell.setCellValue(sourceCell.getBooleanCellValue());
                break;
            case FORMULA:
                targetCell.setCellFormula(sourceCell.getCellFormula());
                break;
            //default:

        }
    }

        public static void copyCellFormat(Cell sourceCell, Cell targetCell, Workbook workbook) {
            // Copy cell style
            CellStyle sourceCellStyle = sourceCell.getCellStyle();
            CellStyle targetCellStyle = workbook.createCellStyle();
            targetCellStyle.cloneStyleFrom(sourceCellStyle);
            targetCell.setCellStyle(targetCellStyle);

            // Set an empty or null value in the target cell
            targetCell.setCellValue("");
        }

    public static int convertInputValueToInt(String inputValue) {

        String outputValue = inputValue.replaceAll(",", "");

        try {
            return Integer.parseInt(outputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric value: " + inputValue, e);
        }
    }




}
