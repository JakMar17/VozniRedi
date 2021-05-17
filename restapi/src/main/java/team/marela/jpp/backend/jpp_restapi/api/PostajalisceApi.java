package team.marela.jpp.backend.jpp_restapi.api;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.dtos.mappers.PostajalisceMapper;
import team.marela.jpp.backend.jpp_restapi.dtos.models.PostajalisceDto;
import team.marela.jpp.backend.jpp_restapi.services.PostajalisceService;

import java.util.Arrays;

@RestController
@RequestMapping("/postajalisce")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostajalisceApi {

    private final PostajalisceService postajalisceService;
    private final PostajalisceMapper postajalisceMapper;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public PostajalisceDto[] getAllPostajalisce() {
        return Arrays.stream(postajalisceService.getAllPostajalisce())
                .map(postajalisceMapper::castDtoFromEntity)
                .toArray(PostajalisceDto[]::new);
    }
}
