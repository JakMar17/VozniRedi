package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Date {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public LocalDate date;
    public double price;

    public void setDate(String date) {
        try {
            this.date = LocalDate.parse(date, dateTimeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
