package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class InStation {
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    public int zap;
    public String postaja;
    public LocalTime prihod;
    public LocalTime odhod;

    public void setPrihod(String prihod) {
        try {
            this.prihod = LocalTime.parse(prihod, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOdhod(String odhod) {
        try {
            this.odhod = LocalTime.parse(odhod, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
