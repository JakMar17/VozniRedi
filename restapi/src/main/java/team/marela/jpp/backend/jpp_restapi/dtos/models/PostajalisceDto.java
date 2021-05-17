package team.marela.jpp.backend.jpp_restapi.dtos.models;

import lombok.Data;

@Data
public class PostajalisceDto {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
}
