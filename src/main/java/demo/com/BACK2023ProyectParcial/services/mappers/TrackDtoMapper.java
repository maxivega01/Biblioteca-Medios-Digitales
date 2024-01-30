package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Playlist;
import demo.com.BACK2023ProyectParcial.entities.Track;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.TrackResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TrackDtoMapper implements Function<Track, TrackResponseDto> {

    @Override
    public TrackResponseDto apply(Track trackEntity) {
        TrackResponseDto trackResponseDto = new TrackResponseDto();

        trackResponseDto.setTrackId(trackEntity.getTrackId());
        trackResponseDto.setName(trackEntity.getName());
        trackResponseDto.setAlbumId(trackEntity.getAlbum().getAlbumId());
        trackResponseDto.setMediaTypesId(trackEntity.getMediaType().getMediatypeId());
        trackResponseDto.setGenresId(trackEntity.getGenre().getGenreId());
        trackResponseDto.setComposer(trackEntity.getComposer());
        trackResponseDto.setMilliseconds(trackEntity.getMilliseconds());
        trackResponseDto.setBytes(trackEntity.getBytes());

        trackEntity.getPlaylists().size();
        trackResponseDto.setPlaylistsId(trackEntity.getPlaylists().stream().map(Playlist::getPlaylistId).toList());
        trackResponseDto.setPlaylistsId(trackEntity.getPlaylists().stream().map(Playlist::getPlaylistId).toList());


        return trackResponseDto;
    }
}