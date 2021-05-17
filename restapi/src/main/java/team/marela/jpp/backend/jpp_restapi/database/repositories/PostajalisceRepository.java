package team.marela.jpp.backend.jpp_restapi.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.marela.jpp.backend.jpp_restapi.database.entities.PostajalisceEntity;

import java.util.Optional;

@Repository
public interface PostajalisceRepository extends JpaRepository<PostajalisceEntity, Integer> {
    Optional<PostajalisceEntity> findByCode(String code);
}
