package team.marela.jpp.backend.jpp_restapi.api.docs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.dtos.mappers.PostajalisceMapper;
import team.marela.jpp.backend.jpp_restapi.dtos.models.PostajalisceDto;
import team.marela.jpp.backend.jpp_restapi.services.PostajalisceService;

import java.util.Arrays;

@RequestMapping("/stations")
@CrossOrigin("*")
public interface PostajalisceApiInterface {

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    PostajalisceDto[] getAllPostajalisce();
}
