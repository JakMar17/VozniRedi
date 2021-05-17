package team.marela.jpp.backend.jpp_restapi.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postajalisce")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostajalisceEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String code;
    private Double latitude;
    private Double longitude;
    private String country;
}
