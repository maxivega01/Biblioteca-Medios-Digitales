package demo.com.BACK2023ProyectParcial.services;

import demo.com.BACK2023ProyectParcial.entities.Track;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.TrackDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.TrackResponseDto;
import demo.com.BACK2023ProyectParcial.repositories.TrackRepository;
import demo.com.BACK2023ProyectParcial.services.mappers.TrackDtoMapper;
import demo.com.BACK2023ProyectParcial.services.mappers.TrackEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImp implements TrackService{

    private final TrackRepository trackRepository;
    private final TrackDtoMapper trackDtoMapper;
    private final TrackEntityMapper trackEntityMapper;

    public TrackServiceImp(TrackRepository trackRepository, TrackDtoMapper trackDtoMapper, TrackEntityMapper trackEntityMapper) {
        this.trackRepository = trackRepository;
        this.trackDtoMapper = trackDtoMapper;
        this.trackEntityMapper = trackEntityMapper;
    }

    @Override
    public TrackResponseDto add(TrackDto trackDto) {
        Track trackToAdd = trackEntityMapper.apply(trackDto);
        trackRepository.save(trackToAdd);

        return  trackDtoMapper.apply(trackToAdd);
    }

    @Override
    public TrackResponseDto update(TrackDto trackDto) {
        Track trackToUpdate = trackRepository.findById(trackDto.getTrackId())
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + trackDto.getTrackId()));

        Track trackWhitChanges = trackEntityMapper.apply(trackDto);

        trackToUpdate.setName(trackWhitChanges.getName());
        trackToUpdate.setAlbum(trackWhitChanges.getAlbum());
        trackToUpdate.setMediaType(trackWhitChanges.getMediaType());
        trackToUpdate.setGenre(trackWhitChanges.getGenre());
        trackToUpdate.setComposer(trackWhitChanges.getComposer());
        trackToUpdate.setMilliseconds(trackWhitChanges.getMilliseconds());
        trackToUpdate.setBytes(trackWhitChanges.getBytes());
        trackToUpdate.setName(trackWhitChanges.getName());
        trackToUpdate.setUnitPrice(trackWhitChanges.getUnitPrice());

        trackRepository.save(trackToUpdate);
        return  trackDtoMapper.apply(trackToUpdate);
    }

    @Override
    public TrackResponseDto delete(Long id) {
        Track trackToDelete = trackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        trackRepository.delete(trackToDelete);
        return  trackDtoMapper.apply(trackToDelete);
    }

    @Override
    public TrackResponseDto getById(Long id) {
        Track trackFound = trackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Platlist no encontrada con el id: " + id));

        return  trackDtoMapper.apply(trackFound);

    }

    @Override
    public List<TrackResponseDto> getAll() {
        List<Track> tracks = trackRepository.findAll();

        return tracks.stream()
                .map(trackDtoMapper)
                .toList();    }
    }
