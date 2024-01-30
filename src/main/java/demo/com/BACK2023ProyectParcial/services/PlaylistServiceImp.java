package demo.com.BACK2023ProyectParcial.services;

import demo.com.BACK2023ProyectParcial.entities.Playlist;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.PlaylistDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.PlaylistResponseDto;
import demo.com.BACK2023ProyectParcial.repositories.PlaylistRepository;
import demo.com.BACK2023ProyectParcial.services.mappers.PlaylistDtoMapper;
import demo.com.BACK2023ProyectParcial.services.mappers.PlaylistEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService{

    private final PlaylistRepository playlistRepository;
    private final PlaylistDtoMapper playlistDtoMapper;
    private final PlaylistEntityMapper playlistEntityMapper;

    public PlaylistServiceImp(PlaylistRepository playlistRepository, PlaylistDtoMapper playlistDtoMapper, PlaylistEntityMapper playlistEntityMapper) {
        this.playlistRepository = playlistRepository;
        this.playlistDtoMapper = playlistDtoMapper;
        this.playlistEntityMapper = playlistEntityMapper;
    }

    @Override
    public PlaylistResponseDto add(PlaylistDto playlistDto) {

        Playlist playlistToAdd = playlistEntityMapper.apply(playlistDto);
        playlistRepository.save(playlistToAdd);

        return  playlistDtoMapper.apply(playlistToAdd);
    }

    @Override
    public PlaylistResponseDto update(PlaylistDto playlistDto) {
        Playlist playlistToUpdate = playlistRepository.findById(playlistDto.getPlaylistId())
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + playlistDto.getPlaylistId()));

        playlistToUpdate.setName(playlistDto.getName());

        playlistRepository.save(playlistToUpdate);
        return  playlistDtoMapper.apply(playlistToUpdate);
    }

    @Override
    public PlaylistResponseDto delete(Long id) {
        Playlist playlistToDelete = playlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        playlistRepository.delete(playlistToDelete);
        return  playlistDtoMapper.apply(playlistToDelete);
    }

    @Override
    public PlaylistResponseDto getById(Long id) {
        Playlist playlistFound = playlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        return  playlistDtoMapper.apply(playlistFound);

    }

    @Override
    public List<PlaylistResponseDto> getAll() {
        List<Playlist> playlists = playlistRepository.findAll();

        return playlists.stream()
                .map(playlistDtoMapper)
                .toList();    }
}