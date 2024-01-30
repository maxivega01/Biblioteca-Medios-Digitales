package demo.com.BACK2023ProyectParcial.repositories.mapping_repositories;

import demo.com.BACK2023ProyectParcial.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
