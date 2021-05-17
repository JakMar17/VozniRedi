package team.marela.jpp.backend.jpp_restapi.database.repositories.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.marela.jpp.backend.jpp_restapi.database.entities.logs.SessionEntity;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {
}
