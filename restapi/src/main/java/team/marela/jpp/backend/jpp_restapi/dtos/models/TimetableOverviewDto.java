package team.marela.jpp.backend.jpp_restapi.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TimetableOverviewDto {
    private String startStop;
    private String endStop;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    private int noOfStops;

    private StationDto[] stations;
}
