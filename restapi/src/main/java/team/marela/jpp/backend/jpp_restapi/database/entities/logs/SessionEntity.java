package team.marela.jpp.backend.jpp_restapi.database.entities.logs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String sessionId;
    private LocalDateTime created;

    @OneToMany(mappedBy = "session")
    private Set<LogEntity> logs;
}
