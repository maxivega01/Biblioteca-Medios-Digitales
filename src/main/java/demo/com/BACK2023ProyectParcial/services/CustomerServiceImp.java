package demo.com.BACK2023ProyectParcial.services;

import demo.com.BACK2023ProyectParcial.entities.Customer;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.CustomerDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.CustomerResponseDto;
import demo.com.BACK2023ProyectParcial.repositories.CustomerRepository;
import demo.com.BACK2023ProyectParcial.services.mappers.CustomerDtoMapper;
import demo.com.BACK2023ProyectParcial.services.mappers.CustomerEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerDtoMapper;
    private final CustomerEntityMapper customerEntityMapper;

    public CustomerServiceImp(CustomerRepository customerRepository, CustomerDtoMapper customerDtoMapper, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerDtoMapper = customerDtoMapper;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public CustomerResponseDto add(CustomerDto customerDto) {
        Customer customerToAdd = customerEntityMapper.apply(customerDto);
        customerRepository.save(customerToAdd);

        return  customerDtoMapper.apply(customerToAdd);   
    }

    @Override
    public CustomerResponseDto update(CustomerDto customerDto) {
        
        Customer customerToUpdate = customerRepository.findById(customerDto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + customerDto.getCustomerId()));

        Customer customerWhitChanges = customerEntityMapper.apply(customerDto);

        customerToUpdate.setFirstName(customerWhitChanges.getFirstName());
        customerToUpdate.setLastName(customerWhitChanges.getLastName());
        customerToUpdate.setCompany(customerWhitChanges.getCompany());
        customerToUpdate.setAddress(customerWhitChanges.getAddress());
        customerToUpdate.setCity(customerWhitChanges.getCity());
        customerToUpdate.setState(customerWhitChanges.getState());
        customerToUpdate.setCountry(customerWhitChanges.getCountry());
        customerToUpdate.setPostalCode(customerWhitChanges.getPostalCode());
        customerToUpdate.setPhone(customerWhitChanges.getPhone());
        customerToUpdate.setFax(customerWhitChanges.getFax());
        customerToUpdate.setEmail(customerWhitChanges.getEmail());
        customerToUpdate.setEmployee(customerWhitChanges.getEmployee());

        customerRepository.save(customerToUpdate);
        return  customerDtoMapper.apply(customerToUpdate);    }

    @Override
    public CustomerResponseDto delete(Long id) {
        Customer customerToDelete = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        customerRepository.delete(customerToDelete);
        return  customerDtoMapper.apply(customerToDelete);
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        Customer customerFound = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        return customerDtoMapper.apply(customerFound);

    }

    @Override
    public List<CustomerResponseDto> getAll() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customerDtoMapper)
                .toList();    }
}

