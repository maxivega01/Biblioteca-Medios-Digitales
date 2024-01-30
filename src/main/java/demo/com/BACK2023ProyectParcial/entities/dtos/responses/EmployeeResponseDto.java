package demo.com.BACK2023ProyectParcial.entities.dtos.responses;

import demo.com.BACK2023ProyectParcial.entities.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private long employeeId;
    private String lastName;
    private String firstName;
    private String title;
    private long reportsTo;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
}
