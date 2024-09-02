package ec.edu.espe.cyberplaneta.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Using code given by:
 * @author AdminOmarGuevara
 */
public class C_ExcelReportGenerator {
    public void exportToExcel(JTable t) throws IOException {
        File archivoXLS = configureFile();
        if (archivoXLS != null) {
            try {
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                fillData(t, hoja);
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    private File configureFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            File archivoXLS = new File(ruta);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();
            return archivoXLS;
        }
        return null;
    }

    private void fillData(JTable t, Sheet hoja) {
        for (int f = 0; f < t.getRowCount(); f++) {
            Row fila = hoja.createRow(f);
            for (int c = 0; c < t.getColumnCount(); c++) {
                Cell celda = fila.createCell(c);
                if (f == 0) {
                    celda.setCellValue(t.getColumnName(c));
                }
            }
        }
        int filaInicio = 1;
        for (int f = 0; f < t.getRowCount(); f++) {
            Row fila = hoja.createRow(filaInicio);
            filaInicio++;
            for (int c = 0; c < t.getColumnCount(); c++) {
                Cell celda = fila.createCell(c);
                if (t.getValueAt(f, c) instanceof Double) {
                    celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                } else if (t.getValueAt(f, c) instanceof Float) {
                    celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                } else {
                    celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                }
            }
        }
    }
}
