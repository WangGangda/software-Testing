package st02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Excel {
	
	public static List<String> readExcel(String sourceFilePath) {
		List<String> contents = Lists.newArrayList();

        try {

            OPCPackage pkg = OPCPackage.open(sourceFilePath);
            XSSFWorkbook excel = new XSSFWorkbook(pkg);
            //获取第一个sheet
            XSSFSheet sheet = excel.getSheetAt(0);

            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                String username = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();
                if(username.equals("") && password.equals("")) {
                	break;
                }
                else {
                	contents.add(username);
                    contents.add(password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
}