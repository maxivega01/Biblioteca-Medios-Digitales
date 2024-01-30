package demo.com.BACK2023ProyectParcial.controllers;

import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceDto;

import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceResponseDto;
import demo.com.BACK2023ProyectParcial.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDto>> getAll() {
        List<InvoiceResponseDto> invoices = invoiceService.getAll();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDto> getById(@PathVariable Long id) {
        InvoiceResponseDto invoiceFound = invoiceService.getById(id);
        return ResponseEntity.ok(invoiceFound);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> add(@RequestBody InvoiceDto invoice) {
        InvoiceResponseDto invoiceAdded = invoiceService.add(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceAdded);
    }

    @PutMapping
    public ResponseEntity<InvoiceResponseDto> update(@RequestBody InvoiceDto invoice) {
        InvoiceResponseDto invoiceUpdated = invoiceService.update(invoice);
        return ResponseEntity.ok(invoiceUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceResponseDto> delete(@PathVariable Long id) {
        InvoiceResponseDto invoiceDeleted = invoiceService.delete(id);
        return ResponseEntity.ok(invoiceDeleted);

    }
}