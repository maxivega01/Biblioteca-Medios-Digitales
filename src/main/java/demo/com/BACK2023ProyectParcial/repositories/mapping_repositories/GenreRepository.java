package demo.com.BACK2023ProyectParcial.repositories.mapping_repositories;

import demo.com.BACK2023ProyectParcial.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
