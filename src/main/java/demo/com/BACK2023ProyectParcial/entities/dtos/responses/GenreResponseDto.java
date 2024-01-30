package demo.com.BACK2023ProyectParcial.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreResponseDto {

    private long genreId;
    private String name;
}
