package team.marela.jpp.backend.jpp_restapi.database.repositories.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.marela.jpp.backend.jpp_restapi.database.entities.logs.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Integer> {
}
