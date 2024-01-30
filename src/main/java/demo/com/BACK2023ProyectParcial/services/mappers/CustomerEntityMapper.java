package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Customer;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.CustomerDto;
import demo.com.BACK2023ProyectParcial.repositories.mapping_repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerEntityMapper implements Function<CustomerDto, Customer> {


    private final EmployeeRepository employeeRepository;

    public CustomerEntityMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Customer apply(CustomerDto customerDto) {
        Customer customerEntity = new Customer();

        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setCompany(customerDto.getCompany());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setCity(customerDto.getCity());
        customerEntity.setState(customerDto.getState());
        customerEntity.setCountry(customerDto.getCountry());
        customerEntity.setPostalCode(customerDto.getPostalCode());
        customerEntity.setPhone(customerDto.getPhone());
        customerEntity.setFax(customerDto.getFax());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setEmployee(employeeRepository.getReferenceById(customerDto.getSupportRepId()));


        return customerEntity;
    }
}
