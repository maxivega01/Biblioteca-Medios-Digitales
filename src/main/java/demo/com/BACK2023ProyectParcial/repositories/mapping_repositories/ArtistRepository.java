package demo.com.BACK2023ProyectParcial.repositories.mapping_repositories;

import demo.com.BACK2023ProyectParcial.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//utiliza lo del JpaRepository y le mando mi entidad y le digo que mi pk es long

@Repository //indico que sera un repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
