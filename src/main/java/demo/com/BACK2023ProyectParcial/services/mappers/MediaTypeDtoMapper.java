package demo.com.BACK2023ProyectParcial.services.mappers;

import demo.com.BACK2023ProyectParcial.entities.MediaType;
import demo.com.BACK2023ProyectParcial.entities.dtos.request.MediaTypeDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class MediaTypeDtoMapper implements Function<MediaType, MediaTypeDto> {
    @Override
    public MediaTypeDto apply(MediaType mediaTypeEntity) {
        return new MediaTypeDto(
                mediaTypeEntity.getMediatypeId(),
                mediaTypeEntity.getName());

    }
}
