package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Date;

@Entity //sera una tabla
@Table(name = "employees") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Employee {

    @Id
    @GeneratedValue(generator = "employee")
    @TableGenerator(name = "employee", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="employeeid", //no se que onda si la ponia minuscula no andaba
            initialValue=8, allocationSize=1)
    @Column(name = "employeeid")
    private long employeeId;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    private String title;

    @ManyToOne
    @JoinColumn(name = "reportsto")
    private Employee reportsTo;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "hiredate")
    private Date hireDate;

    private String address;
    private String city;
    private String state;
    private String country;

    @Column(name = "postalcode")
    private String postalCode;

    private String phone;
    private String fax;
    private String email;
}
