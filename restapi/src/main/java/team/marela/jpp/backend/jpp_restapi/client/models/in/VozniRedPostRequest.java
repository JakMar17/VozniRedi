package team.marela.jpp.backend.jpp_restapi.client.models.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class VozniRedPostRequest {
    @JsonProperty("from_code")
    private Integer fromCode;
    @JsonProperty("to_code")
    private Integer toCode;
    @JsonProperty("departure")
    private String departureDate = null;
    @JsonProperty("return")
    private String returnDate = null;
    private Boolean oneWayTicket = null;
    private Integer adult = 1;
    private Integer children = 0;
    @JsonProperty("children_2")
    private Integer children2 = 0;

    public VozniRedPostRequest(String fromCode, String toCode) {
        this.fromCode = Integer.parseInt(fromCode);
        this.toCode = Integer.parseInt(toCode);
//        setReturnDate(LocalDate.now());
//        setDepartureDate(LocalDate.now());
    }

    public VozniRedPostRequest(String fromCode, String toCode, String departureDate) {
        this.fromCode = Integer.parseInt(fromCode);
        this.toCode = Integer.parseInt(toCode);
        this.departureDate = departureDate;
    }



    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void setFromCode(String fromCode) {
        this.fromCode = Integer.parseInt(fromCode);
    }

    public void setToCode(String toCode) {
        this.toCode = Integer.parseInt(toCode);
    }


    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate.format(dateTimeFormatter);
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate.format(dateTimeFormatter);
    }
}
