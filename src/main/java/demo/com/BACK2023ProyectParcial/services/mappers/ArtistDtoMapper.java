package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Artist;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.ArtistDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ArtistDtoMapper implements Function<Artist, ArtistDto> {
    @Override
    public ArtistDto apply(Artist artistEntity) {
        return new ArtistDto(
                artistEntity.getArtistId(),
                artistEntity.getName());
    }
}