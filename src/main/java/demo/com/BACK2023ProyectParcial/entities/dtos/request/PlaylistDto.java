package demo.com.BACK2023ProyectParcial.entities.dtos.request;

import demo.com.BACK2023ProyectParcial.entities.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto {

    private long playlistId;
    private String name;
}
