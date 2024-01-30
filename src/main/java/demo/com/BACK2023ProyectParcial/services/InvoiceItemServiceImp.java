package demo.com.BACK2023ProyectParcial.services;

import demo.com.BACK2023ProyectParcial.entities.InvoiceItem;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.InvoiceItemDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.InvoiceItemResponseDto;
import demo.com.BACK2023ProyectParcial.repositories.InvoiceItemRepository;
import demo.com.BACK2023ProyectParcial.services.mappers.InvoiceItemDtoMapper;
import demo.com.BACK2023ProyectParcial.services.mappers.InvoiceItemEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceItemServiceImp implements InvoiceItemService{

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceItemDtoMapper invoiceItemDtoMapper;
    private final InvoiceItemEntityMapper invoiceItemEntityMapper;

    public InvoiceItemServiceImp(InvoiceItemRepository invoiceItemRepository, InvoiceItemDtoMapper invoiceItemDtoMapper, InvoiceItemEntityMapper invoiceItemEntityMapper) {
        this.invoiceItemRepository = invoiceItemRepository;
        this.invoiceItemDtoMapper = invoiceItemDtoMapper;
        this.invoiceItemEntityMapper = invoiceItemEntityMapper;
    }


    @Override
    public InvoiceItemResponseDto add(InvoiceItemDto invoiceItemDto) {
        InvoiceItem invoiceItemToAdd = invoiceItemEntityMapper.apply(invoiceItemDto);
        invoiceItemRepository.save(invoiceItemToAdd);

        return  invoiceItemDtoMapper.apply(invoiceItemToAdd);
    }

    @Override
    public InvoiceItemResponseDto update(InvoiceItemDto invoiceItemDto) {
        InvoiceItem invoiceItemToUpdate = invoiceItemRepository.findById(invoiceItemDto.getInvoiceLineId())
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + invoiceItemDto.getInvoiceLineId()));

        InvoiceItem invoiceItemWhitChanges = invoiceItemEntityMapper.apply(invoiceItemDto);

        invoiceItemToUpdate.setInvoice(invoiceItemWhitChanges.getInvoice());
        invoiceItemToUpdate.setTrack(invoiceItemWhitChanges.getTrack());
        invoiceItemToUpdate.setUnitPrice(invoiceItemWhitChanges.getUnitPrice());
        invoiceItemToUpdate.setQuantity(invoiceItemWhitChanges.getQuantity());

        invoiceItemRepository.save(invoiceItemToUpdate);
        return  invoiceItemDtoMapper.apply(invoiceItemToUpdate);
    }

    @Override
    public InvoiceItemResponseDto delete(Long id) {
        InvoiceItem invoiceItemToDelete = invoiceItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        invoiceItemRepository.delete(invoiceItemToDelete);
        return  invoiceItemDtoMapper.apply(invoiceItemToDelete);
    }

    @Override
    public InvoiceItemResponseDto getById(Long id) {
        InvoiceItem invoiceItemFound = invoiceItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        return  invoiceItemDtoMapper.apply(invoiceItemFound);

    }

    @Override
    public List<InvoiceItemResponseDto> getAll() {
        List<InvoiceItem> invoiceItems = invoiceItemRepository.findAll();

        return invoiceItems.stream()
                .map(invoiceItemDtoMapper)
                .toList();    }
}
