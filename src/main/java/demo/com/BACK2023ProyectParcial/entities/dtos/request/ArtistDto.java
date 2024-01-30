package demo.com.BACK2023ProyectParcial.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {

    private long artistId;
    private String name;
}
