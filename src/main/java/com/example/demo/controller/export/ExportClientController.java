package com.example.demo.controller.export;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dto.ClientDto;
import com.example.demo.service.ClientService;

/**
 * Controller pour réaliser l'export des clients.
 */
@Controller
@RequestMapping("export/clients")
public class ExportClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Export des articles au format CSV.
     */
    @GetMapping("csv")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;");

        PrintWriter writer = response.getWriter();
        writer.println("Nom;Prénom;Age");
        List<ClientDto> clients = clientService.findAll();
        for (ClientDto client : clients) {
            writer.println(client.getNom() + ";" + client.getPrenom() + ";" + client.getAge());
        }
    }

    @GetMapping("xlsx")
    public void exportXLSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment; filename=\"export-clients.xlsx\"");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clients");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBottomBorderColor(IndexedColors.BLUE.getIndex());
        cellStyle.setTopBorderColor(IndexedColors.BLUE.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.BLUE.getIndex());
        cellStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());

        CellStyle cellStyleHeader = workbook.createCellStyle();
        cellStyleHeader.cloneStyleFrom(cellStyle);
        Font font = workbook.createFont();
        font.setColor(IndexedColors.PINK.getIndex());
        font.setBold(true);
        cellStyleHeader.setFont(font);

        Row header = sheet.createRow(0);

        Cell cellHeaderNom = header.createCell(0);
        cellHeaderNom.setCellValue("Nom");
        cellHeaderNom.setCellStyle(cellStyleHeader);

        Cell cellHeaderPrenom = header.createCell(1);
        cellHeaderPrenom.setCellValue("Prénom");
        cellHeaderPrenom.setCellStyle(cellStyleHeader);

        Cell cellHeaderAge = header.createCell(2);
        cellHeaderAge.setCellValue("Age");
        cellHeaderAge.setCellStyle(cellStyleHeader);

        List<ClientDto> clientDtos = clientService.findAll();
        int i = 0;
        for (ClientDto clientDto : clientDtos) {
            Row row = sheet.createRow(i + 1);
            Cell cellNom = row.createCell(0);
            Cell cellPrenom = row.createCell(1);
            Cell cellAge = row.createCell(2);
            cellNom.setCellValue(clientDto.getNom());
            cellNom.setCellStyle(cellStyle);
            cellPrenom.setCellValue(clientDto.getPrenom());
            cellPrenom.setCellStyle(cellStyle);
            cellAge.setCellValue(clientDto.getAge());
            cellAge.setCellStyle(cellStyle);
            i++;
        }

        workbook.write(outputStream);
        workbook.close();
    }
}
// import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;