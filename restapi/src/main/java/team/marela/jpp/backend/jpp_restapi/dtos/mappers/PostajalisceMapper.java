package team.marela.jpp.backend.jpp_restapi.dtos.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import team.marela.jpp.backend.jpp_restapi.database.entities.PostajalisceEntity;
import team.marela.jpp.backend.jpp_restapi.dtos.models.PostajalisceDto;

@Service
@RequiredArgsConstructor
public class PostajalisceMapper {
    private final ModelMapper modelMapper;

    public PostajalisceDto castDtoFromEntity(PostajalisceEntity entity) {
        return modelMapper.map(entity, PostajalisceDto.class);
    }
}
