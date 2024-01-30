package demo.com.BACK2023ProyectParcial.repositories;

import demo.com.BACK2023ProyectParcial.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
