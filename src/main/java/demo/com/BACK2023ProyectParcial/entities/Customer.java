package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //sera una tabla
@Table(name = "customers") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Customer {

    @Id
    @GeneratedValue(generator = "customer")
    @TableGenerator(name = "customer", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "customerid", //no se que onda si la ponia minuscula no andaba
            initialValue = 59, allocationSize = 1)
    @Column(name = "customerid")
    private long customerId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String company;
    private String address;
    private String city;
    private String state;
    private String country;

    @Column(name = "postalcode")
    private String postalCode;

    private String phone;
    private String fax;
    private String email;

    @ManyToOne
    @JoinColumn(name = "supportrepid")
    private Employee employee;

}
