package team.marela.jpp.backend.jpp_restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.api.docs.PostajalisceApiInterface;
import team.marela.jpp.backend.jpp_restapi.dtos.mappers.PostajalisceMapper;
import team.marela.jpp.backend.jpp_restapi.dtos.models.PostajalisceDto;
import team.marela.jpp.backend.jpp_restapi.services.PostajalisceService;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class PostajalisceApi implements PostajalisceApiInterface {

    private final PostajalisceService postajalisceService;
    private final PostajalisceMapper postajalisceMapper;

    public PostajalisceDto[] getAllPostajalisce() {
        return Arrays.stream(postajalisceService.getAllPostajalisce())
                .map(postajalisceMapper::castDtoFromEntity)
                .toArray(PostajalisceDto[]::new);
    }
}
