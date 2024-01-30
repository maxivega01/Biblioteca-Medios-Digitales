package demo.com.BACK2023ProyectParcial.services;

import demo.com.BACK2023ProyectParcial.entities.Invoice;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceResponseDto;
import demo.com.BACK2023ProyectParcial.repositories.InvoiceRepository;
import demo.com.BACK2023ProyectParcial.services.mappers.InvoiceDtoMapper;
import demo.com.BACK2023ProyectParcial.services.mappers.InvoiceEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImp implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;
    private final InvoiceEntityMapper invoiceEntityMapper;

    public InvoiceServiceImp(InvoiceRepository invoiceRepository, InvoiceDtoMapper invoiceDtoMapper, InvoiceEntityMapper invoiceEntityMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.invoiceEntityMapper = invoiceEntityMapper;
    }

    @Override
    public InvoiceResponseDto add(InvoiceDto invoiceDto) {
        Invoice invoiceToAdd = invoiceEntityMapper.apply(invoiceDto);
        invoiceRepository.save(invoiceToAdd);

        return  invoiceDtoMapper.apply(invoiceToAdd);
    }

    @Override
    public InvoiceResponseDto update(InvoiceDto invoiceDto) {
        Invoice invoiceToUpdate = invoiceRepository.findById(invoiceDto.getInvoiceId())
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + invoiceDto.getInvoiceId()));

        Invoice invoiceWhitChanges = invoiceEntityMapper.apply(invoiceDto);

        invoiceToUpdate.setCustomer(invoiceWhitChanges.getCustomer());
        invoiceToUpdate.setInvoiceDate(invoiceWhitChanges.getInvoiceDate());
        invoiceToUpdate.setBillingAddress(invoiceWhitChanges.getBillingAddress());
        invoiceToUpdate.setBillingCity(invoiceWhitChanges.getBillingCity());
        invoiceToUpdate.setBillingState(invoiceWhitChanges.getBillingState());
        invoiceToUpdate.setBillingCountry(invoiceWhitChanges.getBillingCountry());
        invoiceToUpdate.setBillingPostalCode(invoiceWhitChanges.getBillingPostalCode());
        invoiceToUpdate.setTotal(invoiceWhitChanges.getTotal());

        invoiceRepository.save(invoiceToUpdate);
        return  invoiceDtoMapper.apply(invoiceToUpdate);    }

    @Override
    public InvoiceResponseDto delete(Long id) {

        Invoice invoiceToDelete = invoiceRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        invoiceRepository.delete(invoiceToDelete);
        return  invoiceDtoMapper.apply(invoiceToDelete);
    }

    @Override
    public InvoiceResponseDto getById(Long id) {
        Invoice invoiceFound = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        return  invoiceDtoMapper.apply(invoiceFound);

    }

    @Override
    public List<InvoiceResponseDto> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();

        return invoices.stream()
                .map(invoiceDtoMapper)
                .toList();    }
}

