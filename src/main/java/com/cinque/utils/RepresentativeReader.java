package com.cinque.utils;


import com.cinque.testdata.DTO.RepresentativeDetailsData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RepresentativeReader {

    public class RepresentativeDataReader {

        private static final String EXCEL_PATH = "src/test/resources/testdata/testdata.xlsx";
        private static final String SHEET_NAME = "representatives";


        public static List<RepresentativeDetailsData> getRepresentatives(String testCaseName) {

            List<RepresentativeDetailsData> result = new ArrayList<>();

            try (FileInputStream file = new FileInputStream(EXCEL_PATH);
                 Workbook workbook = new XSSFWorkbook(file)) {

                Sheet sheet = workbook.getSheet(SHEET_NAME);

                if (sheet == null) {
                    System.out.println("Sheet '" + SHEET_NAME + "' not found — returning empty list");
                    return Collections.emptyList();
                }

                // Step 1 — Read header row to build column index map
                Row headerRow = sheet.getRow(0);
                Map<String, Integer> columnIndex = new HashMap<>();
                for (Cell cell : headerRow) {
                    columnIndex.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
                }

                // Step 2 — Read data rows
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) continue;

                    String rowTestCaseName = getCellValue(row, columnIndex, "testCaseName");

                    // Step 3 — Filter by testCaseName
                    if (!testCaseName.equalsIgnoreCase(rowTestCaseName)) continue;

                    // Step 4 — Map row to DTO
                    RepresentativeDetailsData data = RepresentativeDetailsData.builder()
                            .testCaseName(rowTestCaseName)
                            .repOrder(Integer.parseInt(getCellValue(row, columnIndex, "repOrder")))
                            .representativeType(getCellValue(row, columnIndex, "representativeType"))
                            .representativeFirstName(getCellValue(row, columnIndex, "representativeFirstName"))
                            .representativeMiddleName(normalize(getCellValue(row, columnIndex, "representativeMiddleName")))
                            .representativeLastName(getCellValue(row, columnIndex, "representativeLastName"))
                            .representativeGender(getCellValue(row, columnIndex, "representativeGender"))
                            .representativeDOB(getCellValue(row, columnIndex, "representativeDOB"))
                            .representativeNationality(getCellValue(row, columnIndex, "representativeNationality"))
                            .representativeDualNationality(normalize(getCellValue(row, columnIndex, "representativeDualNationality")))
                            .representativePhoneCode(getCellValue(row, columnIndex, "representativePhoneCode"))
                            .representativePhoneNumber(getCellValue(row, columnIndex, "representativePhoneNumber"))
                            .representativeIdType(getCellValue(row, columnIndex, "representativeIdType"))
                            .representativeIdNumber(getCellValue(row, columnIndex, "representativeIdNumber"))
                            .placeOfIssue(getCellValue(row, columnIndex, "placeOfIssue"))
                            .idIssueDate(getCellValue(row, columnIndex, "idIssueDate"))
                            .idExpiryDate(getCellValue(row, columnIndex, "idExpiryDate"))
                            .idIssueCountry(getCellValue(row, columnIndex, "idIssueCountry"))
                            .visaNumber(normalize(getCellValue(row, columnIndex, "visaNumber")))
                            .visaIdExpiryDate(normalize(getCellValue(row, columnIndex, "visaIdExpiryDate")))
                            .relation(getCellValue(row, columnIndex, "relation"))
                            .share(getCellValue(row, columnIndex, "share"))
                            .repIdImagePath(splitImagePaths(getCellValue(row, columnIndex, "repIdImagePath")))
                            .build();

                    result.add(data);
                }

            } catch (IOException e) {
                throw new RuntimeException("Failed to read representatives sheet: " + e.getMessage(), e);
            }

            // Step 5 — Sort by repOrder before returning
            result.sort(Comparator.comparingInt(RepresentativeDetailsData::getRepOrder));
            return result;
        }

        // Safely reads cell value as String regardless of cell type
        private static String getCellValue(Row row, Map<String, Integer> columnIndex, String columnName) {
            Integer idx = columnIndex.get(columnName);
            if (idx == null) return "";

            Cell cell = row.getCell(idx);
            if (cell == null) return "";

            return switch (cell.getCellType()) {
                case STRING  -> cell.getStringCellValue().trim();
                case NUMERIC -> DateUtil.isCellDateFormatted(cell)
                        ? new DataFormatter().formatCellValue(cell)  // keeps date as string
                        : String.valueOf((long) cell.getNumericCellValue());
                case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                case FORMULA -> cell.getCachedFormulaResultType() == CellType.NUMERIC
                        ? String.valueOf((long) cell.getNumericCellValue())
                        : cell.getStringCellValue().trim();
                default      -> "";
            };
        }

        // Treats "-" or blank as empty — aligns with isNotBlank() guards in page methods
        private static String normalize(String value) {
            if (value == null || value.isBlank() || value.trim().equals("-")) {
                return "";
            }
            return value.trim();
        }
        private static List<String> splitImagePaths(String value) {
            if (value == null || value.isBlank() || value.trim().equals("-")) {
                return Collections.emptyList();
            }
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }

    }

}
