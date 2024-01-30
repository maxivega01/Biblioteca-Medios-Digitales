package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Album;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.AlbumDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class AlbumDtoMapper implements Function<Album, AlbumDto> {
    @Override
    public AlbumDto apply(Album albumEntity) {
        return new AlbumDto(
                albumEntity.getAlbumId(),
                albumEntity.getTitle(),
                albumEntity.getArtist().getArtistId());

    }
}