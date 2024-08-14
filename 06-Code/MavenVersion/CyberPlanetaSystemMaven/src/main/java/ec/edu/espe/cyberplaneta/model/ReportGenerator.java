/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.model;

import com.itextpdf.text.DocumentException;
import ec.edu.espe.cyberplaneta.controller.PdfReport;
import java.io.IOException;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE 
 */
public class ReportGenerator {
    public void generatePdfReport(JFreeChart chart) throws IOException, DocumentException {
        PdfReport pdfReport = new PdfReport();
        pdfReport.exportChartToPDF(chart);
    }
}

//GENERA LOS INFORMES ESPECIFICOS SINGLE RESPONSABILITY