package demo.com.BACK2023ProyectParcial.repositories.mapping_repositories;

import demo.com.BACK2023ProyectParcial.entities.Album;
import demo.com.BACK2023ProyectParcial.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
