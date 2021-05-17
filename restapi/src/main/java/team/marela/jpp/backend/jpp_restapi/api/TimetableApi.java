package team.marela.jpp.backend.jpp_restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.api.docs.TimetableApiInterface;
import team.marela.jpp.backend.jpp_restapi.dtos.models.TimetableOverviewDto;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;
import team.marela.jpp.backend.jpp_restapi.services.TimetableServices;

@RestController
@RequiredArgsConstructor
public class TimetableApi implements TimetableApiInterface {

    private final TimetableServices timetableServices;

    public TimetableOverviewDto[] getTimetable(
            Integer from,
            Integer to,
            String date
            ) throws DataNotFoundException {
        return timetableServices.getTimetable(from, to, date);
    }


}
