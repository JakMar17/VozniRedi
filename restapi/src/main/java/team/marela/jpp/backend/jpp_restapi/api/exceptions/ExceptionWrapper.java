package team.marela.jpp.backend.jpp_restapi.api.exceptions;

import lombok.Data;

@Data
public class ExceptionWrapper {
    private final String[] errors;

    public ExceptionWrapper(String error) {
        this.errors = new String[]{error};
    }

    public ExceptionWrapper(String[] errors) {
        this.errors = errors;
    }
}
