package team.marela.jpp.backend.jpp_restapi.api.docs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.dtos.models.TimetableOverviewDto;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;

@CrossOrigin("*")
@RequestMapping("/timetable")
public interface TimetableApiInterface {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    TimetableOverviewDto[] getTimetable(
            @RequestParam Integer from,
            @RequestParam Integer to,
            @RequestParam String date
    ) throws DataNotFoundException;
}
