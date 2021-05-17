package team.marela.jpp.backend.jpp_restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.marela.jpp.backend.jpp_restapi.client.VozniRedRetreiver;
import team.marela.jpp.backend.jpp_restapi.client.models.in.VozniRedPostRequest;
import team.marela.jpp.backend.jpp_restapi.client.models.out.RootVozniRedElement;
import team.marela.jpp.backend.jpp_restapi.dtos.mappers.TimetableOverviewMapper;
import team.marela.jpp.backend.jpp_restapi.dtos.models.TimetableOverviewDto;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;

import java.time.LocalDate;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VozniRedApi {

    private final VozniRedRetreiver vozniRedRetreiver;
    private final TimetableOverviewMapper timetableOverviewMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TimetableOverviewDto[] test(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date
            ) throws DataNotFoundException {
        var req = new VozniRedPostRequest(from, to, date);
        var data = vozniRedRetreiver.getVozniRed(req);
        return timetableOverviewMapper.mapFromRootVozniRedElementToOverviewDto(data);
    }


}
