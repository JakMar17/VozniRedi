package team.marela.jpp.backend.jpp_restapi.dtos.mappers;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import team.marela.jpp.backend.jpp_restapi.client.models.out.RootVozniRedElement;
import team.marela.jpp.backend.jpp_restapi.database.repositories.PostajalisceRepository;
import team.marela.jpp.backend.jpp_restapi.dtos.models.StationDto;
import team.marela.jpp.backend.jpp_restapi.dtos.models.StopDto;
import team.marela.jpp.backend.jpp_restapi.dtos.models.TimetableOverviewDto;
import team.marela.jpp.backend.jpp_restapi.exceptions.DataNotFoundException;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TimetableOverviewMapper {
    private final ModelMapper modelMapper;
    private final PostajalisceRepository postajalisceRepository;

    public TimetableOverviewDto[] mapFromRootVozniRedElementToOverviewDto(RootVozniRedElement el) throws DataNotFoundException {

        var list = new ArrayList<TimetableOverviewDto>();

        for (var e : el.departures) {
            list.add(
                    new TimetableOverviewDto(
                            postajalisceRepository.findByCode(e.from_code + "").orElseThrow(() -> new DataNotFoundException("Ne najdem postaje")).getName(),
                            postajalisceRepository.findByCode(e.to_code + "").orElseThrow(() -> new DataNotFoundException("Ne najdem postaje")).getName(),
                            e.departure,
                            e.time_from,
                            e.time_to,
                            e.ride_time,
                            e.stops,
                            CollectionUtils.emptyIfNull(e.stations).stream()
                                    .map(f -> new StationDto(
                                                    f.zacetnaPostaja,
                                                    f.koncnaPostaja,
                                                    f.odhod,
                                                    f.prihod,
                                                    f.casVoznje,
                                                    f.cakanje,
                                                    CollectionUtils.emptyIfNull(f.in_stations).stream()
                                                            .map(g -> new StopDto(
                                                                    g.zap,
                                                                    g.postaja,
                                                                    g.prihod,
                                                                    g.odhod
                                                            ))
                                                            .toArray(StopDto[]::new)
                                            )
                                    ).toArray(StationDto[]::new)
                    )
            );
        }

        return list.toArray(TimetableOverviewDto[]::new);
    }
}
