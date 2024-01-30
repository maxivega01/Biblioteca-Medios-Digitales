package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.Genre;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.GenreDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class GenreDtoMapper implements Function<Genre, GenreDto> {
    @Override
    public GenreDto apply(Genre genreEntity) {
        return new GenreDto(
                genreEntity.getGenreId(),
                genreEntity.getName());
    }
}