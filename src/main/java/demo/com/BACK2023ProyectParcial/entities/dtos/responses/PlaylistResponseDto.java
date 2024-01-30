package demo.com.BACK2023ProyectParcial.entities.dtos.responses;

import demo.com.BACK2023ProyectParcial.entities.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistResponseDto {

    private long playlistId;
    private String name;
    private List<Long> tracksId;
}
