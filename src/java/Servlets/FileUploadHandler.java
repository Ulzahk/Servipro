/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controles.Conexion;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PRACTICANTE
 */
public class FileUploadHandler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnImportarDatos") != null) {
            redireccion(request, response);
        } else if (request.getParameter("subirExcel") != null) {

        }
    }

    private File ArchivosSubidos;

    public void redireccion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.getRequestDispatcher("Empleados/importararchivosexcel.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private static final long serialVersionUID = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            ArchivosSubidos = new File("C:\\", "ArchivosSubidos");
            ArchivosSubidos.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String file_name = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            return;
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            Connection conn = Conexion.conectar();
            List< FileItem> fields = upload.parseRequest(request);
            Iterator< FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals("file_name")) {
                            file_name = fileItem.getString();
                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                        String outputFileNm = ((file_name == null || file_name.equals("")) ? fileItem.getName() : file_name);
                        String fileNameSuffix = "." + FilenameUtils.getExtension(fileItem.getName());
                        File outputFile = new File(outputFileNm);
                        fileItem.write(new File("C:\\ArchivosSubidos\\" + outputFile.getName() + fileNameSuffix));

                        FileInputStream file = new FileInputStream(new File("C:\\ArchivosSubidos\\" + outputFile.getName() + fileNameSuffix));

                        XSSFWorkbook wb = new XSSFWorkbook(file);
                        XSSFSheet sheet = wb.getSheetAt(0);

                        

                        for (int a = 1; a <= 1000; a++) {
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
                    }
                }
            }

        } catch (Exception e) {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);
        }
    }
}
