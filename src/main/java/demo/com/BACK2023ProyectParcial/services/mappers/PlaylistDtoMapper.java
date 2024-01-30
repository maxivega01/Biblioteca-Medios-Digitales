package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Playlist;
import demo.com.BACK2023ProyectParcial.entities.Track;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.PlaylistResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlaylistDtoMapper implements Function<Playlist, PlaylistResponseDto> {

    @Override
    public PlaylistResponseDto apply(Playlist playlistEntity) {
        PlaylistResponseDto playlistResponseDto = new PlaylistResponseDto();

        playlistResponseDto.setPlaylistId(playlistEntity.getPlaylistId());
        playlistResponseDto.setName(playlistEntity.getName());
        playlistResponseDto.setTracksId(playlistEntity.getTracks().stream().map(Track::getTrackId).toList());

            return playlistResponseDto;

    }
}
