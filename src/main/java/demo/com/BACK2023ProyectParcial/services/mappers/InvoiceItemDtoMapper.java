package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.InvoiceItem;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceItemResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceItemDtoMapper implements Function<InvoiceItem, InvoiceItemResponseDto> {
    
    @Override
    public InvoiceItemResponseDto apply(InvoiceItem invoiceItemEntity) {
        InvoiceItemResponseDto invoiceItemResponseDto = new InvoiceItemResponseDto();

        invoiceItemResponseDto.setInvoiceLineId(invoiceItemEntity.getInvoiceLineId());
        invoiceItemResponseDto.setInvoiceId(invoiceItemEntity.getInvoice().getInvoiceId());
        invoiceItemResponseDto.setTrackId(invoiceItemEntity.getTrack().getTrackId());
        invoiceItemResponseDto.setUnitPrice(invoiceItemEntity.getUnitPrice());
        invoiceItemResponseDto.setQuantity(invoiceItemEntity.getQuantity());

        return invoiceItemResponseDto;
    }
}
