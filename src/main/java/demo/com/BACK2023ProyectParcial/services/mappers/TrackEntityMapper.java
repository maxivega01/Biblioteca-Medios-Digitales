package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Track;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.TrackDto;
import demo.com.BACK2023ProyectParcial.repositories.mapping_repositories.AlbumRepository;
import demo.com.BACK2023ProyectParcial.repositories.mapping_repositories.GenreRepository;
import demo.com.BACK2023ProyectParcial.repositories.mapping_repositories.MediaTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class TrackEntityMapper implements Function<TrackDto, Track> {

    private final AlbumRepository albumRepository;
    private final MediaTypeRepository mediaTypeRepository;
    private final GenreRepository genreRepository;

    public TrackEntityMapper(AlbumRepository albumRepository, MediaTypeRepository mediaTypeRepository, GenreRepository genreRepository) {
        this.albumRepository = albumRepository;
        this.mediaTypeRepository = mediaTypeRepository;
        this.genreRepository = genreRepository;
    }


    @Override
    public Track apply(TrackDto trackDto) {
        Track trackEntity = new Track();

        trackEntity.setName(trackDto.getName());
        trackEntity.setAlbum(albumRepository.getReferenceById(trackDto.getAlbumId()));
        trackEntity.setMediaType(mediaTypeRepository.getReferenceById(trackDto.getMediaTypesId()));
        trackEntity.setGenre(genreRepository.getReferenceById(trackDto.getGenresId()));
        trackEntity.setComposer(trackDto.getComposer());
        trackEntity.setMilliseconds(trackDto.getMilliseconds());
        trackEntity.setBytes(trackDto.getBytes());
        trackEntity.setName(trackDto.getName());
        trackEntity.setUnitPrice(trackDto.getUnitPrice());
        trackEntity.setUnitPrice(trackDto.getUnitPrice());
        trackEntity.setPlaylists(new ArrayList<>());
        //trackEntity.setPlaylists(trackDto.getPlaylistsId().stream().map(playlistRepository::getReferenceById).toList());


        return trackEntity;

    }
}