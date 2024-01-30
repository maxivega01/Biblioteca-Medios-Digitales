package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Invoice;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceDto;
import demo.com.BACK2023ProyectParcial.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceEntityMapper implements Function<InvoiceDto, Invoice> {

    private final CustomerRepository customerRepository;

    public InvoiceEntityMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Invoice apply(InvoiceDto invoiceDto) {
        Invoice invoiceEntity = new Invoice();

        invoiceEntity.setCustomer(customerRepository.getReferenceById(invoiceDto.getCustomerId()));
        invoiceEntity.setInvoiceDate(invoiceDto.getInvoiceDate());
        invoiceEntity.setBillingAddress(invoiceDto.getBillingAddress());
        invoiceEntity.setBillingCity(invoiceDto.getBillingCity());
        invoiceEntity.setBillingState(invoiceDto.getBillingState());
        invoiceEntity.setBillingCountry(invoiceDto.getBillingCountry());
        invoiceEntity.setBillingPostalCode(invoiceDto.getBillingPostalCode());
        invoiceEntity.setTotal(invoiceDto.getTotal());

        return invoiceEntity;
    }
}
