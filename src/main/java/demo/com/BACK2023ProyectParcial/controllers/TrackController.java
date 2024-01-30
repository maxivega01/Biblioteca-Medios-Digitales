package demo.com.BACK2023ProyectParcial.controllers;

import demo.com.BACK2023ProyectParcial.entities.dtos.request.TrackDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.TrackResponseDto;
import demo.com.BACK2023ProyectParcial.services.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/track")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<List<TrackResponseDto>> getAll() {
        List<TrackResponseDto> tracks = trackService.getAll();
        return ResponseEntity.ok(tracks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackResponseDto> getById(@PathVariable Long id) {
        TrackResponseDto trackFound = trackService.getById(id);
        return ResponseEntity.ok(trackFound);
    }

    @PostMapping
    public ResponseEntity<TrackResponseDto> add(@RequestBody TrackDto track) {
        TrackResponseDto trackAdded = trackService.add(track);
        return ResponseEntity.status(HttpStatus.CREATED).body(trackAdded);
    }

    @PutMapping
    public ResponseEntity<TrackResponseDto> update(@RequestBody TrackDto track) {
        TrackResponseDto TrackUpdated = trackService.update(track);
        return ResponseEntity.ok(TrackUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrackResponseDto> delete(@PathVariable Long id) {
        TrackResponseDto trackDeleted = trackService.delete(id);
        return ResponseEntity.ok(trackDeleted);

    }
}