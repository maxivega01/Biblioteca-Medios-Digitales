package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Invoice;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceDtoMapper implements Function<Invoice, InvoiceResponseDto> {
    @Override
    public InvoiceResponseDto apply(Invoice invoiceEntity) {
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();

        invoiceResponseDto.setInvoiceId(invoiceEntity.getInvoiceId());

        if (invoiceEntity.getCustomer() != null) {
            invoiceResponseDto.setCustomerId(invoiceEntity.getCustomer().getCustomerId());
        }

        invoiceResponseDto.setInvoiceDate(invoiceEntity.getInvoiceDate());
        invoiceResponseDto.setBillingAddress(invoiceEntity.getBillingAddress());
        invoiceResponseDto.setBillingCity(invoiceEntity.getBillingCity());
        invoiceResponseDto.setBillingState(invoiceEntity.getBillingState());
        invoiceResponseDto.setBillingCountry(invoiceEntity.getBillingCountry());
        invoiceResponseDto.setBillingPostalCode(invoiceEntity.getBillingPostalCode());
        invoiceResponseDto.setTotal(invoiceEntity.getTotal());

        return invoiceResponseDto;
    }
}
