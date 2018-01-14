package com.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FixerCurrencyResponse {
    private String base;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Map<String, Double> rates;
}
