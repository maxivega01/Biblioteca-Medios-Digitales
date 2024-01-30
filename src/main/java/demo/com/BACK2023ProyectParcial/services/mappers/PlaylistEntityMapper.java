package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Playlist;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.PlaylistDto;
import demo.com.BACK2023ProyectParcial.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;
@Service
public class PlaylistEntityMapper implements Function<PlaylistDto, Playlist> {

    @Override
    public Playlist apply(PlaylistDto playlistDto) {

        Playlist playlistEntity = new Playlist();

        playlistEntity.setName(playlistDto.getName());
        playlistEntity.setTracks(new ArrayList<>());

        //playlistEntity.setTracks(playlistDto.getTracksId().stream().map(trackRepository::getReferenceById).toList());

        return playlistEntity;
    }
}
