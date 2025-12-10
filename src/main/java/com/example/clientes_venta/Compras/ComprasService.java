package com.example.clientes_venta.Compras;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service // Usamos @Service en lugar de @Component por convención
public class ComprasService {
    
    private final ComprasRepo comprasRepo;

    @Autowired
    public ComprasService(ComprasRepo comprasRepo) {
        this.comprasRepo = comprasRepo;
    }

    // 1. CORRECCIÓN: Renombrado a getAllCompras para coincidir con el Controlador
    public List<Compras> getAllCompras(){
        return comprasRepo.findAll();
    }

    // 2. AGREGADO: La lógica para generar el Excel (Faltaba esto)
    
    public ByteArrayInputStream generarExcel() throws IOException {
        // Nuevas columnas
        String[] columnas = {"ID Orden", "Producto", "Cant.", "Fecha", "Estatus", "Total"};
        List<Compras> compras = comprasRepo.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Mis Compras");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for (Compras compra : compras) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(compra.getId());
                row.createCell(1).setCellValue(compra.getProducto()); // Producto
                row.createCell(2).setCellValue(compra.getCantidad()); // Cantidad
                row.createCell(3).setCellValue(compra.getFecha().toString());
                row.createCell(4).setCellValue(compra.getEstatus());
                row.createCell(5).setCellValue(compra.getTotal());
            }

            for(int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}