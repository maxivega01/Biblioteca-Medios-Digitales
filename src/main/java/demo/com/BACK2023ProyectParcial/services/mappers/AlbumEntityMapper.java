package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Album;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.AlbumDto;
import demo.com.BACK2023ProyectParcial.repositories.mapping_repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlbumEntityMapper implements Function<AlbumDto, Album> {
    private final ArtistRepository artistRepository;

    public AlbumEntityMapper(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Album apply(AlbumDto albumDto) {
        return new Album(
                albumDto.getAlbumId(),
                albumDto.getTitle(),
                artistRepository.getReferenceById(albumDto.getArtistId()));

    }
}