package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Customer;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

    @Service
    public class CustomerDtoMapper implements Function<Customer, CustomerResponseDto> {

        @Override
        public CustomerResponseDto apply(Customer customerEntity) {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();

            customerResponseDto.setCustomerId(customerEntity.getCustomerId());
            customerResponseDto.setFirstName(customerEntity.getFirstName());
            customerResponseDto.setLastName(customerEntity.getLastName());
            customerResponseDto.setCompany(customerEntity.getCompany());
            customerResponseDto.setAddress(customerEntity.getAddress());
            customerResponseDto.setCity(customerEntity.getCity());
            customerResponseDto.setState(customerEntity.getState());
            customerResponseDto.setCountry(customerEntity.getCountry());
            customerResponseDto.setPostalCode(customerEntity.getPostalCode());
            customerResponseDto.setPhone(customerEntity.getPhone());
            customerResponseDto.setFax(customerEntity.getFax());
            customerResponseDto.setEmail(customerEntity.getEmail());
            customerResponseDto.setSupportRepId(customerEntity.getEmployee().getEmployeeId());

            return customerResponseDto;
        }
    }
