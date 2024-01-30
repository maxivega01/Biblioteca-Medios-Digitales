package demo.com.BACK2023ProyectParcial.controllers;

import demo.com.BACK2023ProyectParcial.entities.dtos.request.CustomerDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.CustomerResponseDto;
import demo.com.BACK2023ProyectParcial.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        List<CustomerResponseDto> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {
        CustomerResponseDto customerFound = customerService.getById(id);
        return ResponseEntity.ok(customerFound);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> add(@RequestBody CustomerDto customer) {
        CustomerResponseDto customerAdded = customerService.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerAdded);
    }

    @PutMapping
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerDto customer) {
        CustomerResponseDto customerUpdated = customerService.update(customer);
        return ResponseEntity.ok(customerUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> delete(@PathVariable Long id) {
        CustomerResponseDto customerDeleted = customerService.delete(id);
        return ResponseEntity.ok(customerDeleted);

    }
}