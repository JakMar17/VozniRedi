package team.marela.jpp.backend.jpp_restapi.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class StopDto {
    private Integer inSequence;
    private String station;
    private LocalTime arrivingTime;
    private LocalTime departureTime;

//    @JsonIgnore
//    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//    public StopDto(Integer inSequence, String station, String arrivingTime, String departureTime) {
//        this.inSequence = inSequence;
//        this.station = station;
//        this.arrivingTime = LocalTime.parse(arrivingTime, timeFormatter);
//        this.departureTime = LocalTime.parse(departureTime, timeFormatter);
//    }
}
