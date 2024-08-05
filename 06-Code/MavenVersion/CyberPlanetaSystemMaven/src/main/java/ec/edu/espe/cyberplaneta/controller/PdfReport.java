package ec.edu.espe.cyberplaneta.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class PdfReport {

    public void exportTableToPDF(JTable table) throws IOException, DocumentException {
        File pdfFile = configureFile();
        if (pdfFile != null) {
            try {
                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                document.open();

                addContent(document, table);

                document.close();
                Desktop.getDesktop().open(pdfFile);
            } catch (DocumentException | IOException e) {
                throw e;
            }
        }
    }

    private File configureFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().toString().concat(".pdf");
            return new File(path);
        }
        return null;
    }

    private void addContent(Document document, JTable table) throws DocumentException, IOException {
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
    }

    public void exportChartToPDF(JFreeChart chart) throws IOException, DocumentException {
        File pdfFile = configureFile();
        if (pdfFile != null) {
            try {
                Document document = new Document(PageSize.A4);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                document.open();

                addChartToDocument(document, chart);

                document.close();
                Desktop.getDesktop().open(pdfFile);
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar el gráfico como PDF.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addChartToDocument(Document document, JFreeChart chart) throws IOException, DocumentException {
        BufferedImage chartImage = chart.createBufferedImage(800, 600);
        File tempFile = new File("tempChart.png");
        ImageIO.write(chartImage, "png", tempFile);

        Image pdfImage = Image.getInstance("tempChart.png");
        pdfImage.setAlignment(Element.ALIGN_CENTER);
        pdfImage.scaleToFit(PageSize.A4.getWidth() - 50, PageSize.A4.getHeight() - 150);
        document.add(pdfImage);

        tempFile.delete();
    }
}