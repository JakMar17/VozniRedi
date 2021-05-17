package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.util.List;

@Data
public class RootVozniRedElement {
    public List<Date> dates;
    public List<Departure> departures;
}
