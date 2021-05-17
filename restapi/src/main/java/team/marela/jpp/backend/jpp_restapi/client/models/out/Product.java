package team.marela.jpp.backend.jpp_restapi.client.models.out;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Product {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public int prod_id;
    public String naziv;
    public double price;
    public int notax;
    public double tax;
    public int from_code;
    public int to_code;
    public LocalDate dest_date;
    public int quantity;

    public void setDest_date(String dest_date) {
        try {
            this.dest_date = LocalDate.parse(dest_date, dateFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
