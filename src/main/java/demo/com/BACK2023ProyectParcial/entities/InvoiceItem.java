package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //sera una tabla
@Table(name = "invoice_items") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class InvoiceItem {
    @Id
    @GeneratedValue(generator = "invoice_item")
    @TableGenerator(name = "invoice_item", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="invoicelineid",
            initialValue=2240, allocationSize=1)
    @Column(name = "invoicelineid")
    private long invoiceLineId;

    @OneToOne
    @JoinColumn(name = "invoiceid")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "trackid")
    private Track track;

    @Column(name = "unitprice")
    private int unitPrice;

    private int quantity;
}
