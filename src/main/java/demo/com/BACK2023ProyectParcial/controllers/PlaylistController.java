package demo.com.BACK2023ProyectParcial.controllers;

import demo.com.BACK2023ProyectParcial.entities.dtos.request.PlaylistDto;
import demo.com.BACK2023ProyectParcial.entities.dtos.responses.PlaylistResponseDto;
import demo.com.BACK2023ProyectParcial.services.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponseDto>> getAll() {
        List<PlaylistResponseDto> playlists = playlistService.getAll();
        return ResponseEntity.ok(playlists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponseDto> getById(@PathVariable Long id) {
        PlaylistResponseDto playlistFound = playlistService.getById(id);
        return ResponseEntity.ok(playlistFound);}

    @PostMapping
    public ResponseEntity<PlaylistResponseDto> add(@RequestBody PlaylistDto playlist) {
        PlaylistResponseDto playlistAdded = playlistService.add(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistAdded);
    }

    @PutMapping
    public ResponseEntity<PlaylistResponseDto> update(@RequestBody PlaylistDto playlist) {
        PlaylistResponseDto playlistUpdated = playlistService.update(playlist);
        return ResponseEntity.ok(playlistUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlaylistResponseDto> delete(@PathVariable Long id) {
        PlaylistResponseDto playlistDeleted = playlistService.delete(id);
        return ResponseEntity.ok(playlistDeleted);
    }

}
