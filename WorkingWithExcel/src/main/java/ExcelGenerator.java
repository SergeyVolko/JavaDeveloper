import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelGenerator {

    public static void main(String[] args) {
        List<Data> dataList = getData(); // Получите ваши данные
        generateExcel(dataList);
    }

    private static List<Data> getData() {
        // Замените на вашу логику получения данных
        return Arrays.asList(
                new Data("Group1", "Item1", 10),
                new Data("Group1", "Item2", 20),
                new Data("Group2", "Item3", 30),
                new Data("Group2", "Item4", 40)
        );
    }

    private static void generateExcel(List<Data> dataList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Grouped Data");

        // Группировка данных
        Map<String, List<Data>> groupedData = new HashMap<>();
        for (Data data : dataList) {
            groupedData.computeIfAbsent(data.getGroup(), k -> new ArrayList<>()).add(data);
        }

        int rowNum = 0;
        for (Map.Entry<String, List<Data>> entry : groupedData.entrySet()) {
            String group = entry.getKey();
            List<Data> items = entry.getValue();

            // Создание строки для группы
            Row groupRow = sheet.createRow(rowNum++);
            Cell groupCell = groupRow.createCell(0);
            groupCell.setCellValue(group);
            groupCell.setCellStyle(createGroupStyle(workbook));

            // Создание строк для элементов группы
            for (Data item : items) {
                Row itemRow = sheet.createRow(rowNum++);
                itemRow.createCell(1).setCellValue(item.getName());
                itemRow.createCell(2).setCellValue(item.getValue());
            }
        }

        // Запись в файл
        try (FileOutputStream fileOut = new FileOutputStream("grouped_data.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static CellStyle createGroupStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    static class Data {
        private String group;
        private String name;
        private int value;

        public Data(String group, String name, int value) {
            this.group = group;
            this.name = name;
            this.value = value;
        }

        public String getGroup() {
            return group;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}

