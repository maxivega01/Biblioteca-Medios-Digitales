package demo.com.BACK2023ProyectParcial.entities.dtos.responses;

import demo.com.BACK2023ProyectParcial.entities.Track;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemResponseDto {

    private long invoiceLineId;
    private long invoiceId;
    private long trackId;
    private int unitPrice;
    private int quantity;
}

