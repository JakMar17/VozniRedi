package team.marela.jpp.backend.jpp_restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.marela.jpp.backend.jpp_restapi.client.VozniRedRetreiver;
import team.marela.jpp.backend.jpp_restapi.client.models.in.VozniRedPostRequest;
import team.marela.jpp.backend.jpp_restapi.database.repositories.PostajalisceRepository;
import team.marela.jpp.backend.jpp_restapi.dtos.mappers.TimetableOverviewMapper;
import team.marela.jpp.backend.jpp_restapi.dtos.models.TimetableOverviewDto;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;

@Service
@RequiredArgsConstructor
public class TimetableServices {
    private final VozniRedRetreiver vozniRedRetreiver;
    private final TimetableOverviewMapper timetableOverviewMapper;
    private final PostajalisceRepository postajalisceRepository;

    public TimetableOverviewDto[] getTimetable(
            Integer from,
            Integer to,
            String date
    ) throws DataNotFoundException {
        var stationFrom = postajalisceRepository.findById(from).orElseThrow(() -> new DataNotFoundException("Iskana postaja ne obstaja"));
        var stationTo = postajalisceRepository.findById(to).orElseThrow(() -> new DataNotFoundException("Iskana postaja ne obstaja"));


        var req = new VozniRedPostRequest(stationFrom.getCode(), stationTo.getCode(), date);
        var data = vozniRedRetreiver.getVozniRed(req);
        return timetableOverviewMapper.mapFromRootVozniRedElementToOverviewDto(data);
    }

}
