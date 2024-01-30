package demo.com.BACK2023ProyectParcial.entities.dtos.request;

import demo.com.BACK2023ProyectParcial.entities.Artist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {

    private long albumId;
    private String title;
    private long artistId;

}
