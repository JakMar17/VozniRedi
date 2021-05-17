package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class Station {
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    public int zap;
    public String zacetnaPostaja;
    public String koncnaPostaja;
    public LocalTime odhod;
    public LocalTime prihod;
    public int casVoznje;
    public String cakanje;
    public List<InStation> in_stations;

    public void setOdhod(String odhod) {
        try {
            this.odhod = LocalTime.parse(odhod, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPrihod(String prihod) {
        try {
            this.prihod = LocalTime.parse(prihod, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
