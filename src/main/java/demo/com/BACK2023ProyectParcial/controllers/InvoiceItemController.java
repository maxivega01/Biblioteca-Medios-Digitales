package demo.com.BACK2023ProyectParcial.controllers;

import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceItemDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceItemResponseDto;
import demo.com.BACK2023ProyectParcial.services.InvoiceItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoice/item")
public class InvoiceItemController {
    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemResponseDto>> getAll() {
        List<InvoiceItemResponseDto> invoiceItems = invoiceItemService.getAll();
        return ResponseEntity.ok(invoiceItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemResponseDto> getById(@PathVariable Long id) {
        InvoiceItemResponseDto invoiceItemFound = invoiceItemService.getById(id);
        return ResponseEntity.ok(invoiceItemFound);
    }

    @PostMapping
    public ResponseEntity<InvoiceItemResponseDto> add(@RequestBody InvoiceItemDto invoiceItem) {
        InvoiceItemResponseDto invoiceItemAdded = invoiceItemService.add(invoiceItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceItemAdded);
    }

    @PutMapping
    public ResponseEntity<InvoiceItemResponseDto> update(@RequestBody InvoiceItemDto invoiceItem) {
        InvoiceItemResponseDto invoiceItemUpdated = invoiceItemService.update(invoiceItem);
        return ResponseEntity.ok(invoiceItemUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceItemResponseDto> delete(@PathVariable Long id) {
        InvoiceItemResponseDto invoiceItemDeleted = invoiceItemService.delete(id);
        return ResponseEntity.ok(invoiceItemDeleted);

    }
}