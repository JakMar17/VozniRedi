package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class Departure {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    public int planer;
    public int from_code;
    public int to_code;
    public LocalTime time_from;
    public LocalTime time_to;
    public LocalDate departure;
    public LocalTime ride_time;
    public LocalTime arrived_at;
    public double price;
    public double priceAvarage;
    public double adultPrice;
    public double convert_price;
    public int km;
    public int stops;
    public List<Product> products;
    public List<Station> stations;

    public void setTime_from(String time_from) {
        try {
            this.time_from = LocalTime.parse(time_from, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTime_to(String time_to) {
        try {
            this.time_to = LocalTime.parse(time_to, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDeparture(String departure) {
        try {
            this.departure = LocalDate.parse(departure, dateFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRide_time(String ride_time) {
        try {
            this.ride_time = LocalTime.parse(ride_time, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setArrived_at(String arrived_at) {
        try {
            this.arrived_at = LocalTime.parse(arrived_at, timeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
