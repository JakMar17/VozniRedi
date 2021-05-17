package team.marela.jpp.backend.jpp_restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.marela.jpp.backend.jpp_restapi.database.entities.PostajalisceEntity;
import team.marela.jpp.backend.jpp_restapi.database.repositories.PostajalisceRepository;

@RequiredArgsConstructor
@Service
public class PostajalisceService {

    private final PostajalisceRepository postajalisceRepository;

    public PostajalisceEntity[] getAllPostajalisce() {
        return postajalisceRepository.findAll().toArray(PostajalisceEntity[]::new);
    }
}
