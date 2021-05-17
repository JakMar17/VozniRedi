package team.marela.jpp.backend.jpp_restapi.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class StationDto {
    private String startStation;
    private String endStation;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer rideTime;
    private Integer waitTime;
    private StopDto[] stops;

    @SneakyThrows
    public StationDto(String startStation, String endStation, LocalTime startTime, LocalTime endTime, Integer rideTime, String waitTime, StopDto[] stops) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rideTime = rideTime;
        try {
            this.waitTime = Integer.parseInt(waitTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.stops = stops;
    }
}
