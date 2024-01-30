package demo.com.BACK2023ProyectParcial.repositories;

import demo.com.BACK2023ProyectParcial.entities.InvoiceItem;
import demo.com.BACK2023ProyectParcial.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
