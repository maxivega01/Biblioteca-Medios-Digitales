package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity //sera una tabla
@Table(name = "invoices") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Invoice {

    @Id
    @GeneratedValue(generator = "invoice")
    @TableGenerator(name = "invoice", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="invoiceid", //no se que onda si la ponia minuscula no andaba
            initialValue=412, allocationSize=1)
    @Column(name = "invoiceid")
    private long invoiceId;

    @OneToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @Column(name = "invoicedate")
    private Date invoiceDate;

    @Column(name = "billingaddress")
    private String billingAddress;

    @Column(name = "billingcity")
    private String billingCity;

    @Column(name = "billingcountry")
    private String billingCountry;

    @Column(name = "billingstate")
    private String billingState;

    @Column(name = "billingpostalcode")
    private String billingPostalCode;

    private int total;


}