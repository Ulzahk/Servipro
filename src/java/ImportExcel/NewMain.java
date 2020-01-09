/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import BL.clsConexion;
import Controles.Conexion;
import java.sql.Connection;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.dev.XSSFSave;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewMain {

    /**
     * @param args the command line arguments
     */

    Connection conn = null;
    PreparedStatement ps;

    public NewMain() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
/*
    public static void crearExcel() {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Hola Java");

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Hola Mundo");
        row.createCell(1).setCellValue(7.5);
        row.createCell(2).setCellValue(true);

        Cell celda = row.createCell(3);
        celda.setCellFormula(String.format("1+1", ""));

        Row rowUno = sheet.createRow(1);
        rowUno.createCell(0).setCellValue(7);
        rowUno.createCell(1).setCellValue(8);

        Cell celdados = rowUno.createCell(2);
        celdados.setCellFormula(String.format("A%d+B%d", 2, 2));

        try {
            FileOutputStream fileout = new FileOutputStream("Excel.xlsx");
            book.write(fileout);
            fileout.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void leer() throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\productos.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 0; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                int numCols = fila.getLastCellNum();

                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    switch (celda.getCellTypeEnum().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;

                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;

                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }

                }

                System.out.println("");

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    public static void cargar(ImportExcel.clsRutaDeImportar obclsRutaDeImportar) throws IOException, SQLException {

        try {
            Connection conn = Conexion.conectar();
            FileInputStream file = new FileInputStream(new File(obclsRutaDeImportar.getRuta()));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);

                PreparedStatement ps = conn.prepareStatement("{call spInsertarEmpleado(?,?,?,?,?,?,?,?,?)}");
                ps.setInt(1, fila.getCell(0).getCellType());
                ps.setString(2, fila.getCell(1).getStringCellValue());
                ps.setString(3, fila.getCell(2).getStringCellValue());
                ps.setString(4, fila.getCell(3).getStringCellValue());
                ps.setString(5, fila.getCell(4).getStringCellValue());
                ps.setString(6, fila.getCell(5).getStringCellValue());
                ps.setString(7, fila.getCell(6).getStringCellValue());
                ps.setInt(8, fila.getCell(7).getCellType());
                ps.setInt(9, fila.getCell(8).getCellType());
                
                ps.execute();
            }


        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public static void modificar() throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\productos.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            XSSFRow fila = sheet.getRow(1);

            if (fila == null) {
                fila = sheet.createRow(1);
            }

            XSSFCell celda = fila.createCell(1);

            if (celda == null) {
                celda = fila.createCell(1);
            }

            celda.setCellValue("Modificacion");

            file.close();

            FileOutputStream output = new FileOutputStream("D:\\nuevo.xlsx");
            wb.write(output);
            output.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}
