package com.example.demo.controller.export;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Controller pour réaliser l'export des factures.
 */
@Controller
@RequestMapping("export/factures")
public class ExportFactureController {

    @GetMapping("{idFacture}/pdf")
    public void exportPDF(@PathVariable Long idFacture, HttpServletRequest request, HttpServletResponse response)
        throws IOException, DocumentException {
        response.setHeader("Content-Disposition", "attachment; filename=\"export-facture-" + idFacture + ".pdf\"");
        OutputStream outputStream = response.getOutputStream();

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        Paragraph paragrapheHeader1 = new Paragraph();
        paragrapheHeader1.add("hello");
        document.add(paragrapheHeader1);

        PdfPTable table = new PdfPTable(4);
        table.addCell("Article");
        table.addCell("Prix unitaire");
        table.addCell("Quantité");
        table.addCell("Prix");

        table.addCell("exemple1");
        table.addCell("22");
        table.addCell("2");
        table.addCell("44");

        document.add(table);
        document.close();
    }
}