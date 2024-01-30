package demo.com.BACK2023ProyectParcial.entities.dtos.responses;

import demo.com.BACK2023ProyectParcial.entities.Artist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponseDto {

    private long albumId;
    private String title;
    private long artistId;

}
