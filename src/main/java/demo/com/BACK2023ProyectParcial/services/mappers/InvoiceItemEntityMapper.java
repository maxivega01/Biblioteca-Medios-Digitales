package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.InvoiceItem;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceItemDto;
import demo.com.BACK2023ProyectParcial.repositories.InvoiceRepository;
import demo.com.BACK2023ProyectParcial.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceItemEntityMapper implements Function<InvoiceItemDto, InvoiceItem> {

    private final InvoiceRepository invoiceRepository;
    private final TrackRepository trackRepository;


    public InvoiceItemEntityMapper(InvoiceRepository invoiceRepository, TrackRepository trackRepository) {
        this.invoiceRepository = invoiceRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public InvoiceItem apply(InvoiceItemDto invoiceItemDto) {
        InvoiceItem invoiceItemEntity = new InvoiceItem();

        invoiceItemEntity.setInvoice(invoiceRepository.getReferenceById(invoiceItemDto.getInvoiceId()));
        invoiceItemEntity.setTrack(trackRepository.getReferenceById(invoiceItemDto.getTrackId()));
        invoiceItemEntity.setUnitPrice(invoiceItemDto.getUnitPrice());
        invoiceItemEntity.setQuantity(invoiceItemDto.getQuantity());

        return invoiceItemEntity;

    }
}


