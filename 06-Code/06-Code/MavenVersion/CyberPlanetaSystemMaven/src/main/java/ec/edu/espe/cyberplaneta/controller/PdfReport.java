package ec.edu.espe.cyberplaneta.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class PdfReport {

    public void exportToPDF(JTable table) throws IOException, DocumentException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().toString().concat(".pdf");
            try {
                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
                document.open();

                BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/SEGOEUI.TTF", BaseFont.WINANSI, BaseFont.EMBEDDED);
                Font titleFont = new Font(baseFont, 20, Font.BOLD, BaseColor.BLACK);

                Paragraph title = new Paragraph("Reportes de Cyber Planeta", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);

                document.add(title);

                document.add(new Paragraph(" "));

                Image logo = Image.getInstance(getClass().getResource("/images/cyberplanetalogo.png"));
                logo.setAlignment(Element.ALIGN_CENTER);
                logo.scaleToFit(100, 100);
                document.add(logo);

                document.add(new Paragraph(" "));

                PdfPCell borderCell = new PdfPCell();
                borderCell.setBorderWidthTop(2f);
                borderCell.setBorderColorTop(new BaseColor(7, 81, 203));
                borderCell.setFixedHeight(2f);

                PdfPTable borderTable = new PdfPTable(1);
                borderTable.setWidthPercentage(100);
                borderTable.addCell(borderCell);
                document.add(borderTable); 

                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                pdfTable.setWidthPercentage(100);

                for (int i = 0; i < table.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i)));
                    cell.setBackgroundColor(new BaseColor(7, 81, 203));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    pdfTable.addCell(cell);
                }

                for (int rows = 0; rows < table.getRowCount(); rows++) {
                    for (int cols = 0; cols < table.getColumnCount(); cols++) {
                        PdfPCell cell = new PdfPCell(new Phrase(table.getValueAt(rows, cols).toString()));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        pdfTable.addCell(cell);
                    }
                }
                document.add(pdfTable);

                borderCell = new PdfPCell();
                borderCell.setBorderWidthBottom(2f);
                borderCell.setBorderColorBottom(new BaseColor(7, 81, 203));
                borderCell.setFixedHeight(2f);

                borderTable = new PdfPTable(1);
                borderTable.setWidthPercentage(100);
                borderTable.addCell(borderCell);
                document.add(borderTable); 

                document.close();

                Desktop.getDesktop().open(new File(path));
            } catch (DocumentException | IOException e) {
                throw e;
            }
        }
    }
}
