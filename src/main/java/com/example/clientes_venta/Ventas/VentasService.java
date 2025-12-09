package com.example.clientes_venta.Ventas;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class VentasService {
    
    private final VentasRepo ventasRepo;

    @Autowired
    public VentasService(VentasRepo ventasRepo) {
        this.ventasRepo = ventasRepo;
    }

    public List<Ventas> getAllVentas(){
        return ventasRepo.findAll();
    }

    // --- NUEVO MÉTODO PARA EXCEL ---
    public ByteArrayInputStream generarExcel() throws IOException {
        String[] columnas = {"ID Orden", "Cliente", "Fecha", "Estatus", "Precio"};
        List<Ventas> ventas = ventasRepo.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Ventas");

            // Crear estilo para el encabezado (Negrita)
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Crear Fila de Encabezados
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Llenar datos
            int rowIdx = 1;
            for (Ventas venta : ventas) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(venta.getId());
                row.createCell(1).setCellValue(venta.getClienteNombre());
                row.createCell(2).setCellValue(venta.getFecha().toString());
                row.createCell(3).setCellValue(venta.getEstatus());
                row.createCell(4).setCellValue(venta.getTotal());
            }

            // Ajustar ancho de columnas automáticamente
            for(int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}