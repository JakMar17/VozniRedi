package team.marela.jpp.backend.jpp_restapi.database.entities.logs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String httpMethod;
    private String url;

    @ManyToOne
    @JoinColumn
    private SessionEntity session;

}
